package org.jboss.as.quickstarts.kitchensink.model;

import java.io.Serializable;
import javax.persistence.*;
import org.jboss.as.quickstarts.kitchensink.model.BaseActivity;

/**
 * A General activity that do not lies in Neky, Gunah & Lagooh
 * 
 * @author AffanHasan
 */
@Entity
@Table(name="general")
public class General extends BaseActivity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public General() {
		super();
	}
}