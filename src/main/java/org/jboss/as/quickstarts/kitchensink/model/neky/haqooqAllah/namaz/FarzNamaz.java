package org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah.namaz;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah.namaz.FarzNamazHealthCategory;
import org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah.namaz.NamazNames;
import org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah.namaz.Namaz;

/**
 * 
 *
 * @author AffanHasan
 */
@Entity
@Table(name="farz_namaz")
public class FarzNamaz extends Namaz implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Enumerated(EnumType.ORDINAL)
	@NotNull(message = "Namaz name must be given")
	private NamazNames name;
	
	@Enumerated(EnumType.ORDINAL)
	@NotNull(message = "Namaz health must be given")
	private FarzNamazHealthCategory health;

	public FarzNamaz() {
		super();
	}
	
	public FarzNamazHealthCategory getHealth() {
		return this.health;
	}

	public void setHealth(FarzNamazHealthCategory health) {
		this.health = health;
	}   
	public NamazNames getName() {
		return this.name;
	}

	public void setName(NamazNames name) {
		this.name = name;
	}
}