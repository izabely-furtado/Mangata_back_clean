package modelo;

import lombok.*;

@Setter @Getter
public class TelefoneTipo {
	private int id_telefone_tipo;
	private String nome;
	
	public TelefoneTipo(int id_telefone_tipo, String nome) {
		super();
		this.id_telefone_tipo = id_telefone_tipo;
		this.nome = nome;
	}
	
	public TelefoneTipo() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "TelefoneTipo [id_telefone_tipo=" + id_telefone_tipo + ", nome=" + nome + "]";
	}

	
}
