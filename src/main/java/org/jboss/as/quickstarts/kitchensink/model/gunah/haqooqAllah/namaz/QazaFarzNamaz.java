package org.jboss.as.quickstarts.kitchensink.model.gunah.haqooqAllah.namaz;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.jboss.as.quickstarts.kitchensink.model.enums.NamazNames;
import org.jboss.as.quickstarts.kitchensink.model.gunah.haqooqAllah.namaz.Namaz;

/**
 * Entity implementation class for Entity: QazaFarzNamaz
 *
 * @author AffanHasan
 */
@Entity
@Table(name="qaza_farz_namaz")
public class QazaFarzNamaz extends Namaz implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Enumerated(EnumType.ORDINAL)
	@NotNull(message = "Namaz name must be given")
	private NamazNames name;
	
	@NotNull(message = "Compensated or not?")
	private Boolean compensated;

	public QazaFarzNamaz() {
		super();
	}   
	public NamazNames getName() {
		return this.name;
	}

	public void setName(NamazNames name) {
		this.name = name;
	}
	public Boolean getCompensated() {
		return compensated;
	}
	public void setCompensated(Boolean compensated) {
		this.compensated = compensated;
	}
}