package org.jboss.as.quickstarts.kitchensink.model.neky;

import java.io.Serializable;
import javax.persistence.*;

import org.jboss.as.quickstarts.kitchensink.model.BaseActivity;

/**
 * Entity implementation class for Entity: Neky
 * 
 * @author AffanHasan
 */

@MappedSuperclass
public abstract class Neky extends BaseActivity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Neky() {
		super();
	}
	
	@Column(name = "improvement_note", length = 313)
	private String improvementNote;

	//BoilerPlate Getters & Setters
	public String getImprovementNote() {
		return improvementNote;
	}

	public void setImprovementNote(String improvementNote) {
		this.improvementNote = improvementNote;
	}
}