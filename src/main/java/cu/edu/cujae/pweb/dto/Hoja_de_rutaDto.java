package cu.edu.cujae.pweb.dto;

import java.sql.Date;

public class Hoja_de_rutaDto {
	private long identificador;
	private long id_carro;
	private Date fecha;
	private double kms;
	private String ci;
	
	public Hoja_de_rutaDto(long identificador, long id_carro, Date fecha, double kms,String ci) {
		super();
		this.identificador = identificador;
		this.id_carro = id_carro;
		this.fecha = fecha;
		this.kms = kms;
		this.ci=ci;
	}
	/**
	 * @return the identificador
	 */
	public long getIdentificador() {
		return identificador;
	}
	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}
	/**
	 * @return the id_carro
	 */
	public long getId_carro() {
		return id_carro;
	}
	/**
	 * @param id_carro the id_carro to set
	 */
	public void setId_carro(long id_carro) {
		this.id_carro = id_carro;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the kms
	 */
	public double getKms() {
		return kms;
	}
	/**
	 * @param kms the kms to set
	 */
	public void setKms(double kms) {
		this.kms = kms;
	}
	/**
	 * @return the ci
	 */
	public String getCi() {
		return ci;
	}
	/**
	 * @param ci the ci to set
	 */
	public void setCi(String ci) {
		this.ci = ci;
	}
	
	
}
