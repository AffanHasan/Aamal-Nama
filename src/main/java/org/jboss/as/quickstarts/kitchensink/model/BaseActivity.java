package org.jboss.as.quickstarts.kitchensink.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.as.quickstarts.kitchensink.model.BaseEntity;

/**
 * Base class for all activities
 *
 * @author AffanHasan
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "day_id", "start_time"}))
public abstract class BaseActivity extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne
	private Day day;
	
	@NotNull
	@Temporal(TemporalType.TIME)
	@Column(name = "start_time")
	private Date startTime;
	
	@NotEmpty(message = "Brief description required")
	@Size(max = 313, message = "Exceeded limit of 313 characters")
	private String description;

	public BaseActivity() {
		super();
	}
	
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Day getDay() {
		return this.day;
	}

	public void setDay(Day day) {
		this.day = day;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
