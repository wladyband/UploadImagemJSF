package javaes.modelo;

import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author javaes
 */
@Entity
public class Imagem implements Serializable {
	private static final long serialVersionUID = 8809683141380592027L;

	public Imagem() {
	}

	@Id
	@GeneratedValue
	private long idImagem;
	private byte[] imagem;
	private String nomeArquivo;

	public long getIdImagem() {
		return idImagem;
	}

	public void setIdImagem(long idImagem) {
		this.idImagem = idImagem;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Imagem other = (Imagem) obj;
		if (this.idImagem != other.idImagem) {
			return false;
		}
		if (!Arrays.equals(this.imagem, other.imagem)) {
			return false;
		}
		if ((this.nomeArquivo == null) ? (other.nomeArquivo != null)
				: !this.nomeArquivo.equals(other.nomeArquivo)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + (int) (this.idImagem ^ (this.idImagem >>> 32));
		hash = 23 * hash + Arrays.hashCode(this.imagem);
		hash = 23 * hash
				+ (this.nomeArquivo != null ? this.nomeArquivo.hashCode() : 0);
		return hash;
	}

}
