package org.jboss.as.quickstarts.kitchensink.model.neky;

import java.io.Serializable;
import javax.persistence.*;
import org.jboss.as.quickstarts.kitchensink.model.neky.Neky;

/**
 * Entity implementation class for Entity: Other
 * 
 * @author AffanHasan
 */
@Entity
@Table(name="uncategorized_neky")
public class UncategorizedNeky extends Neky implements Serializable {

	private static final long serialVersionUID = 1L;

	public UncategorizedNeky() {
		super();
	}
}