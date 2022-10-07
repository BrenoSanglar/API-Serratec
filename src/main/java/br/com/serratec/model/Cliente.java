package br.com.serratec.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Id;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long Id;
	@Column(nullable = true)
	@Size(max = 60, message = "Amigo, você excedeu o limite de caracteres.")
	private String nome;
	@Column(nullable = false, unique = true)
//	@NotBlank(message = "Preencha o cpf.")
	@CPF(message = "Cpf inválido")
	private String cpf;
	@Column
	private LocalDate dataNascimento;
	@Column
	@NotBlank(message = "Preencha o e-mail.")
	@Email(message = "Você inseriu um e-mail inválido.")
	private String email;

	public Cliente(Long id, String nome, String cpf, LocalDate dataNascimento, String email) {
		super();
		Id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [Id=" + Id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ ", email=" + email + "]";
	}

	public Cliente() {
		super();
	}

}
