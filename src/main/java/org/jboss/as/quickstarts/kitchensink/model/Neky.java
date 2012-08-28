package org.jboss.as.quickstarts.kitchensink.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Neky
 * 
 * @author AffanHasan
 */
@Entity
@Table(name = "neky")
public class Neky extends BaseActivity implements Serializable {

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