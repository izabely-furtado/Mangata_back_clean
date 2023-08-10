package modelo;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class UsuarioTelefone {
	private int id_usuario;
	private int ddd;
	private String numero_telefone;
	private int id_telefone_tipo;
	
	public UsuarioTelefone(int id_usuario, int ddd, String numero_telefone, int id_telefone_tipo) {
		super();
		this.id_usuario = id_usuario;
		this.ddd = ddd;
		this.numero_telefone = numero_telefone;
		this.id_telefone_tipo = id_telefone_tipo;
	}
	
	public UsuarioTelefone() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "UsuarioTelefone [id_usuario=" + id_usuario + ", ddd=" + ddd + ", numero_telefone =" + numero_telefone +", id_telefone_tipo=" + id_telefone_tipo + "]";
	}
	

}
