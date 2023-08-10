package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
@Table( name = "usuario_telefone" )
public class UsuarioTelefone {
	@Id
    @Column(name = "id_usuario")
    private int id_usuario;
	
	@Column(name = "ddd")
    private int ddd;
	
	@Column(name = "numero_telefone")
    private String numero_telefone;
	
	@Column(name = "id_telefone_tipo")
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
