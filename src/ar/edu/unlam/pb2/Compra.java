package ar.edu.unlam.pb2;

public class Compra {
	Long cuit;
	Double importe;
	Integer id;
	
	public Compra(Integer id, Long cuit, Double importe) {
		this.id = id;
		this.cuit = cuit;
		this.importe = importe;
	}
	public Long getCuit() {
		return cuit;
	}
	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	

}
