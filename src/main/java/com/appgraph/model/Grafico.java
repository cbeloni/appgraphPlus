package com.appgraph.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement
@Entity
@Table(name="grafico")
public class Grafico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String usuario;
	private String nome_grafico;
	private String eixo_y;
	private String eixo_x;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNome_grafico() {
		return nome_grafico;
	}
	public void setNome_grafico(String nome_grafico) {
		this.nome_grafico = nome_grafico;
	}
	public String getEixo_y() {
		return eixo_y;
	}
	public void setEixo_y(String eixo_y) {
		this.eixo_y = eixo_y;
	}

	public String getEixo_x() {
		return eixo_x;
	}
	public void setEixo_x(String eixo_x) {
		this.eixo_x = eixo_x;
	}
	
	public String toJSON(){
		return new Gson().toJson(this);
	}		
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grafico other = (Grafico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
