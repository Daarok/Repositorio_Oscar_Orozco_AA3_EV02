package com.sena.enventario.crud_springboot.models;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;



public class ProductoDto {
	
	
	@NotEmpty(message="El nombre es obligatorio")	
	private String nombre;
	
	@NotEmpty(message="La categoria es obligatoria")	
	private String categoria;
	
	@NotEmpty(message="El color es obligatorio")	
	private String Color;
	
	@NotEmpty(message="Las dimensiones son obligatorias")	
	private String dimensiones;
	
	@NotEmpty(message="El diseño es obligatorio")	
	private String Diseño;
	
	@NotEmpty(message="La forma es obligatoria	")	
	private String Forma;
	
	@NotEmpty(message="El proveedor es obligatorio")	
	private String Proveedor;
	
	@NotEmpty(message="El proveedor es obligatorio")	
	private String Material;
	
	@Min(0)	
	private float Peso;
	
	@Min(0)		
	private int Stock;
	
	@Min(0)	
	private double precio;
	
	@Size(min=0, message="La descripcion debe tener mínimo 10 caracteres")
	@Size (max=255, message = "La descripción no debe pasar de 255 caracteres")
	private String Descripcion;
	
	private MultipartFile ArchivoImage ;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public String getDiseño() {
		return Diseño;
	}

	public void setDiseño(String diseño) {
		Diseño = diseño;
	}

	public String getForma() {
		return Forma;
	}

	public void setForma(String forma) {
		Forma = forma;
	}

	public String getProveedor() {
		return Proveedor;
	}

	public void setProveedor(String proveedor) {
		Proveedor = proveedor;
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public float getPeso() {
		return Peso;
	}

	public void setPeso(float peso) {
		Peso = peso;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public MultipartFile getArchivoImage() {
		return ArchivoImage;
	}

	public void setArchivoImage(MultipartFile archivoImage) {
		ArchivoImage = archivoImage;
	}

	
	
	
}
