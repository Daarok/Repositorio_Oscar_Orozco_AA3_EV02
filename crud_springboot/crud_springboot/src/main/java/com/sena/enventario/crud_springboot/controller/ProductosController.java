package com.sena.enventario.crud_springboot.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sena.enventario.crud_springboot.models.Producto;
import com.sena.enventario.crud_springboot.models.ProductoDto;
import com.sena.enventario.crud_springboot.services.ProductosRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("productos")
public class ProductosController {

	@Autowired
	private ProductosRepository repo;

	@GetMapping({ "", "/" })
	public String mostrarListaProductos(Model model) {
		List<Producto> productos = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
		model.addAttribute("productos", productos);

		return "productos/index";

	}

	@GetMapping("/crear")
	public String showCreatePage(Model model) {
		ProductoDto productoDto = new ProductoDto();
		model.addAttribute("productoDto", productoDto);
		return "productos/crearproducto";
	}

	@PostMapping("/crear")
	public String crearproducto(@Valid @ModelAttribute ProductoDto productoDto, BindingResult resultado) {
		if (productoDto.getArchivoImage().isEmpty()) {
			resultado.addError(
					new FieldError("productoDto", "ArchivoImage", "El archivo para la imagen es obligatorio"));
		}

		if (resultado.hasErrors()) {
			return "productos/crearproducto";
		}

		// Grabar archivo de la imagen

		MultipartFile image = productoDto.getArchivoImage();
		Date FechaEntrada = new Date(System.currentTimeMillis());
		String storageFileName = FechaEntrada.getTime() + "_" + image.getOriginalFilename();

		try {
			String uploadDir = "public/images/";
			Path uploadPath = Paths.get(uploadDir);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}

			try (InputStream inputStream = image.getInputStream()) {
				Files.copy(inputStream, Paths.get(uploadDir + storageFileName), StandardCopyOption.REPLACE_EXISTING);
			}

		} catch (Exception ex) {
			System.out.println("Exepción al grabar:" + ex.getMessage());
		}

		// Registro en base de datos del nuevo producto

		Producto prod = new Producto();
		prod.setNombre(productoDto.getNombre());
		prod.setDimensiones(productoDto.getDimensiones());
		prod.setDescripcion(productoDto.getDescripcion());
		prod.setDiseño(productoDto.getDiseño());
		prod.setCategoria(productoDto.getCategoria());
		prod.setPrecio(productoDto.getPrecio());
		prod.setPeso(productoDto.getPeso());
		prod.setStock(productoDto.getStock());
		prod.setProveedor(productoDto.getProveedor());
		prod.setMaterial(productoDto.getMaterial());
		prod.setColor(productoDto.getColor());
		prod.setForma(productoDto.getForma());
		prod.setFechaEntrada((java.sql.Date) FechaEntrada);
		prod.setNombreArchivoImagen(storageFileName);

		repo.save(prod);

		return "redirect:/productos";
	}

	@GetMapping("/editar")
	public String ShowEditPag(Model model, @RequestParam int id) {
		try {
			Producto prod = repo.findById(id).get();
			model.addAttribute("producto", prod);

			ProductoDto productoDto = new ProductoDto();
			productoDto.setNombre(prod.getNombre());
			productoDto.setDimensiones(prod.getDimensiones());
			productoDto.setDescripcion(prod.getDescripcion());
			productoDto.setDiseño(prod.getDiseño());
			productoDto.setCategoria(prod.getCategoria());
			productoDto.setPrecio(prod.getPrecio());
			productoDto.setPeso(prod.getPeso());
			productoDto.setStock(prod.getStock());
			productoDto.setProveedor(prod.getProveedor());
			productoDto.setMaterial(prod.getMaterial());
			productoDto.setColor(prod.getColor());
			productoDto.setForma(prod.getForma());

			model.addAttribute("productoDto", productoDto);

		} catch (Exception ex) {
			System.out.println("Excepción al Editar: " + ex.getMessage());
		}

		return "/productos/EditarProducto";
	}

	@PostMapping("/editar")
	public String actualizarProducto(Model model, @RequestParam int id, @Valid @ModelAttribute ProductoDto productoDto,
			BindingResult resultado) {

		try {
			Producto producto = repo.findById(id).get();
			model.addAttribute("producto", producto);

			// Si no hay errores
			if (resultado.hasErrors()) {
				return "/productos/EditarProducto";
			}

			if (!productoDto.getArchivoImage().isEmpty()) {
				// Eliminamos la imagen antigua
				String dirDeImagenes = "public/images";
				Path rutaAntiguaImagen = Paths.get(dirDeImagenes, producto.getNombreArchivoImagen());

				try {
					Files.delete(rutaAntiguaImagen);
				} catch (Exception ex) {
					System.out.println("Excepción: " + ex.getMessage());
				}

				// Grabar el archivo de la nueva imagen
				MultipartFile image = productoDto.getArchivoImage();
				Date FechaEntrada = new Date(System.currentTimeMillis());
				String stringFileName = FechaEntrada.getTime() + "_" + image.getOriginalFilename();

				try (InputStream inputStream = image.getInputStream()) {
					Path imagePath = Paths.get(dirDeImagenes, stringFileName);
					Files.copy(inputStream, imagePath, StandardCopyOption.REPLACE_EXISTING);
				}

				producto.setNombreArchivoImagen(stringFileName);
			}

			producto.setNombre(productoDto.getNombre());
			producto.setDimensiones(productoDto.getDimensiones());
			producto.setDescripcion(productoDto.getDescripcion());
			producto.setDiseño(productoDto.getDiseño());
			producto.setCategoria(productoDto.getCategoria());
			producto.setPrecio(productoDto.getPrecio());
			producto.setPeso(productoDto.getPeso());
			producto.setStock(productoDto.getStock());
			producto.setProveedor(productoDto.getProveedor());
			producto.setMaterial(productoDto.getMaterial());
			producto.setColor(productoDto.getColor());
			producto.setForma(productoDto.getForma());

			repo.save(producto);

		} catch (Exception ex) {
			System.out.println("Error al grabar desde editar: " + ex.getMessage());
		}

		return "redirect:/productos";
	}

	@GetMapping("/delete")
	public String eliminarProducto(@RequestParam int id) {
		System.out.println("Entro la funcion");
		
		try {
			// Intentar encontrar el producto en la base de datos
			Producto producto = repo.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

			// Ruta de la imagen asociada
			Path rutaImagen = Paths.get("public/images", producto.getNombreArchivoImagen());
			
				try {
					Files.delete(rutaImagen);
					
					
				} catch (Exception ex) {
					System.out.println("Error al eliminar la imagen: " + ex.getMessage());

				}
				

			// Eliminar el producto de la base de datos
				
			repo.delete(producto);

		} catch (Exception ex) {
			System.out.println("Error al eliminar el producto: " + ex.getMessage());
		}

		return "redirect:/productos";
	}
	
	

}
