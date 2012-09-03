package org.jboss.as.quickstarts.kitchensink.model.gunah;

import java.io.Serializable;
import javax.persistence.*;
import org.jboss.as.quickstarts.kitchensink.model.gunah.Gunah;

/**
 * Entity implementation class for Entity: UncategorizedGunah
 *
 */
@Entity
@Table(name="uncategorized_gunah")
public class UncategorizedGunah extends Gunah implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public UncategorizedGunah() {
		super();
	}
   
}
