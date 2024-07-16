package com.sena.enventario.crud_springboot.models;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name="productos")

public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String Diseño;
	private String categoria;
	private double precio;
	private String dimensiones;
	private int Stock;
	private String Proveedor;
	private String Material;
	private String Color;
	private float Peso;
	private String Forma;
	
	
	@Column(columnDefinition="Text")
	private String Descripcion;
	private Date FechaEntrada;
	private String NombreArchivoImagen ;
	
	// se insertan los getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDiseño() {
		return Diseño;
	}
	public void setDiseño(String diseño) {
		Diseño = diseño;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
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
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public float getPeso() {
		return Peso;
	}
	public void setPeso(float peso) {
		Peso = peso;
	}
	public String getForma() {
		return Forma;
	}
	public void setForma(String forma) {
		Forma = forma;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Date getFechaEntrada() {
		return FechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		FechaEntrada = fechaEntrada;
	}
	public String getNombreArchivoImagen() {
		return NombreArchivoImagen;
	}
	public void setNombreArchivoImagen(String nombreArchivoImagen) {
		NombreArchivoImagen = nombreArchivoImagen;
	}
	
	
	
	
}
