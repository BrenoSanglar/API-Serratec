package br.com.serratec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column
private Long id;
@Column
private String nome;
@Column
private String cargo;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCargo() {
	return cargo;
}
public void setCargo(String cargo) {
	this.cargo = cargo;
}
@Override
public String toString() {
	return "Funcionario [id=" + id + ", nome=" + nome + ", cargo=" + cargo + "]";
}
public Funcionario(Long id, String nome, String cargo) {
	super();
	this.id = id;
	this.nome = nome;
	this.cargo = cargo;
}
public Funcionario() {
	super();
}

}
