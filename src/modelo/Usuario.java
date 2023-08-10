package modelo;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Usuario {
	private int id_usuario;
	private String nome;
	private String email;
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
