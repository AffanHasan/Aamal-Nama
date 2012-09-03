package org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah;

import java.io.Serializable;
import javax.persistence.*;

import org.jboss.as.quickstarts.kitchensink.model.neky.Neky;


/**
 * Entity implementation class for Entity: HaqooqAllah
 *
 * @author AffanHasan
 */
@MappedSuperclass
public abstract class HaqooqAllah extends Neky implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public HaqooqAllah() {
		super();
	}
}