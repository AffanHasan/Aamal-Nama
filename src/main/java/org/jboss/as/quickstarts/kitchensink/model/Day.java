package org.jboss.as.quickstarts.kitchensink.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.jboss.as.quickstarts.kitchensink.model.gunah.haqooqAllah.namaz.QazaFarzNamaz;
import org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah.namaz.FarzNamaz;

/**
 * Entity implementation class for Entity: Day
 *
 * @author AffanHasan
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "date", "person_id"}))
public class Day extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -7647690467575931834L;
	
	@Column(name = "person_id")
	@NotNull(message = "An integer must be provided for person Id")
	private Long personId;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
	private Set<General> generalActivity = new HashSet<General>();
	
	@OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
	private Set<FarzNamaz> farzNamaz = new HashSet<FarzNamaz>();
	
	@OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
	private Set<QazaFarzNamaz> qazaFarzNamaz = new HashSet<QazaFarzNamaz>();	
	
	//BoilerPlate Getters & Setters
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<General> getGeneralActivity() {
		return generalActivity;
	}
	public void setGeneralActivity(Set<General> generalActivity) {
		this.generalActivity = generalActivity;
	}
	public Set<FarzNamaz> getFarzNamaz() {
		return farzNamaz;
	}
	public void setFarzNamaz(Set<FarzNamaz> farzNamaz) {
		this.farzNamaz = farzNamaz;
	}
	public Set<QazaFarzNamaz> getQazaFarzNamaz() {
		return qazaFarzNamaz;
	}
	public void setQazaFarzNamaz(Set<QazaFarzNamaz> qazaFarzNamaz) {
		this.qazaFarzNamaz = qazaFarzNamaz;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
}