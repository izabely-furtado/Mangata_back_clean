package modelo;

import javax.persistence.*;

import lombok.*;

@Entity
@Setter @Getter
@Table( name = "usuario" )
public class Usuario {
	@Id
    @Column(name = "id_usuario")
    private int id_usuario;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	
	public Usuario(int id_usuario, String nome, String email, String senha) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}

	
	
}
