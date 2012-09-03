package org.jboss.as.quickstarts.kitchensink.controller;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.jboss.as.quickstarts.kitchensink.model.Day;
import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.jboss.as.quickstarts.kitchensink.model.gunah.Gunah;
import org.jboss.as.quickstarts.kitchensink.model.neky.Neky;

// The @Stateful annotation eliminates the need for manual transaction demarcation
@Stateful
// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class MemberRegistration {

   @Inject
   private Logger log;

   @Inject
   private FacesContext facesContext;

   @Inject
   private EntityManager em;

   @Inject
   private Event<Member> memberEventSrc;

   private Member newMember;

   @Produces
   @Named
   public Member getNewMember() {
      return newMember;
   }

   public void register() throws Exception {
      log.info("Registering " + newMember.getName());
      em.persist(newMember);
//    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful"));
      memberEventSrc.fire(newMember);
      
      em.createQuery("select m from Member m order by m.name").getResultList();
      initNewMember();
      
//
	   Day day = new Day();
	   Date date = new Date();
	   day.setDate(date);
	   
//	   Neky neky = new Neky();
//	   neky.setDay(day);
//	   neky.setStartTime(date);
//	   neky.setDescription("Offered qaza Namaz");
//	   neky.setImprovementNote("Leave every thing at the time of namaz; but however if it is qaza then perform it at the first sigh of relief");
	   
//	   Gunah gunah = new Gunah();
//	   gunah.setDay(day);
//	   gunah.setStartTime(date);
//	   gunah.setDescription("Became leaked");
//	   gunah.setRootCause("Lack of self control");
//	   gunah.setRemedy("Always control yourself and look before you leap");
	   
//	   day.getGoodDeeds().add(neky);
//	   day.getBadDeeds().add(gunah);
	   em.persist(day);
   }
   
	/**
	 * @author AffanHasan
	 * 
	 * A method for testing entity persistence
	 */
   public void register(Day day) throws Exception {
	   em.persist(day);
   }
	
   @PostConstruct
   public void initNewMember() {
      newMember = new Member();
   }
}