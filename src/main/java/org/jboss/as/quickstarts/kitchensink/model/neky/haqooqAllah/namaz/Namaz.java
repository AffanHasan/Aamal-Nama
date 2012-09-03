package org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah.namaz;

import java.io.Serializable;
import javax.persistence.*;
import org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah.HaqooqAllah;

/**
 * Entity implementation class for Entity: Namaz
 * 
 * @author AffanHasan
 */
@MappedSuperclass
public abstract class Namaz extends HaqooqAllah implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Namaz() {
		super();
	}
}