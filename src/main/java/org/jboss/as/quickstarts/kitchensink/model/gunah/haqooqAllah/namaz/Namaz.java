package org.jboss.as.quickstarts.kitchensink.model.gunah.haqooqAllah.namaz;

import java.io.Serializable;
import javax.persistence.*;
import org.jboss.as.quickstarts.kitchensink.model.gunah.haqooqAllah.HaqooqAllah;

/**
 * Entity implementation class for Entity: Namaz
 *
 */
@MappedSuperclass
public abstract class Namaz extends HaqooqAllah implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Namaz() {
		super();
	}
   
}
