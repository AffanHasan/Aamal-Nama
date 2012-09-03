package org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah.namaz;

/**
 * A Namaz category means health of a Namaz
 * @author AffanHasan
 *
 */
public enum FarzNamazHealthCategory {
	 A("WITH TAKBEER OOLA")
	,B("WITH OUT TAKBEER OOLA BUT WITH JAMAAT")
	,C("WITH OUT JAMAAT");
	 
	private String description;


	private FarzNamazHealthCategory(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
