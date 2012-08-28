package org.jboss.as.quickstarts.kitchensink.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.as.quickstarts.kitchensink.model.BaseActivity;

/**
 * Entity implementation class for Entity: Gunah
 *
 * @author AffanHasan
 */
@Entity
@Table(name = "gunah")
public class Gunah extends BaseActivity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Column(name="root_cause", length = 313)
	private String rootCause;
	
	@NotEmpty
	@Column(length = 313)
	private String remedy;

	public Gunah() {
		super();
	}
	
	//BoilerPlate Getters & Setters
	public String getRootCause() {
		return this.rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}   
	public String getRemedy() {
		return this.remedy;
	}

	public void setRemedy(String remedy) {
		this.remedy = remedy;
	}
}