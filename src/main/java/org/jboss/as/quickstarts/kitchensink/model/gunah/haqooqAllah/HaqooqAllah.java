package org.jboss.as.quickstarts.kitchensink.model.gunah.haqooqAllah;

import java.io.Serializable;
import javax.persistence.*;
import org.jboss.as.quickstarts.kitchensink.model.gunah.Gunah;

/**
 * Entity implementation class for Entity: HaqooqAllah
 *
 */
@MappedSuperclass

public abstract class HaqooqAllah extends Gunah implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public HaqooqAllah() {
		super();
	}
   
}
