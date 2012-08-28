package org.jboss.as.quickstarts.kitchensink.model;

import java.lang.Long;
import javax.persistence.*;

/**
 * 	This entity will serve as base for almost all entities in this project
 * 
 *	@author AffanHasan
 */
@MappedSuperclass
public abstract class BaseEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	public BaseEntity() {
		super();
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}