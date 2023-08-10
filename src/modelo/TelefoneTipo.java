package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Setter @Getter
@Table( name = "telefone_tipo" )
public class TelefoneTipo {
	@Id
    @Column(name = "id_telefone_tipo")
    private int id_telefone_tipo;
	
	@Column(name = "nome")
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
