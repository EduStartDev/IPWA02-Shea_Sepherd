package shea_sepherd;

import jakarta.persistence.*;

@Entity
public class Geisternetz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	//GPS Daten
	private Double latitude;
	private Double longitude;
	private Integer geschaetzteGroesse;
	@ManyToOne
	private Person melder;
	@Enumerated(EnumType.STRING)
	private GeisternetzStatus status;	
	@ManyToOne
	private Person berger;
	

	//parameterloser Konstruktor für Hibernate
	public Geisternetz() {
		this.status = GeisternetzStatus.GEMELDET;
	} 
	
	//Getters and Setters
	public long getId() {
		return id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getGeschaetzteGroesse() {
		return geschaetzteGroesse;
	}

	public void setGeschaetzteGroesse(Integer geschaetzteGroesse) {
		this.geschaetzteGroesse = geschaetzteGroesse;
	}

	public Person getMelder() {
		return melder;
	}

	public void setMelder(Person melder) {
		this.melder = melder;
	}

	public Person getBerger() {
		return berger;
	}

	public void setBerger(Person berger) {
		this.berger = berger;
	}

	public GeisternetzStatus getStatus() {
		return status;
	}

	public void setStatus(GeisternetzStatus status) {
		this.status = status;
	}
	
	
	

}
