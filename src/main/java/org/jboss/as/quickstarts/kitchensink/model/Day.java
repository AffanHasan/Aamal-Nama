package org.jboss.as.quickstarts.kitchensink.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Day
 *
 * @author AffanHasan
 */
@Entity
public class Day extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -7647690467575931834L;
	
	@NotNull
	@Column(unique = true)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
	private Set<Neky> goodDeeds = new HashSet<Neky>();
	
	@OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
	private Set<Gunah> badDeeds = new HashSet<Gunah>();
	
	@OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
	private Set<Lagooh> useLessDeeds = new HashSet<Lagooh>();
	
	//BoilerPlate Getters & Setters
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Neky> getGoodDeeds() {
		return goodDeeds;
	}

	public void setGoodDeeds(Set<Neky> goodDeeds) {
		this.goodDeeds = goodDeeds;
	}

	public Set<Gunah> getBadDeeds() {
		return badDeeds;
	}

	public void setBadDeeds(Set<Gunah> badDeeds) {
		this.badDeeds = badDeeds;
	}
	public Set<Lagooh> getUseLessDeeds() {
		return useLessDeeds;
	}
	public void setUseLessDeeds(Set<Lagooh> useLessDeeds) {
		this.useLessDeeds = useLessDeeds;
	}
}