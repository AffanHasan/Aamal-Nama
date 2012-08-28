package org.jboss.as.quickstarts.kitchensink.test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.as.quickstarts.kitchensink.controller.MemberRegistration;
import org.jboss.as.quickstarts.kitchensink.model.BaseActivity;
import org.jboss.as.quickstarts.kitchensink.model.BaseEntity;
import org.jboss.as.quickstarts.kitchensink.model.Day;
import org.jboss.as.quickstarts.kitchensink.model.Gunah;
import org.jboss.as.quickstarts.kitchensink.model.Lagooh;
import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.jboss.as.quickstarts.kitchensink.model.Neky;
import org.jboss.as.quickstarts.kitchensink.util.Resources;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MemberRegistrationTest {
   @Deployment
   public static Archive<?> createTestArchive() {
      return ShrinkWrap.create(WebArchive.class, "test.war")
            .addClasses(
            		Member.class, MemberRegistration.class, Resources.class
            		, BaseEntity.class, Day.class, BaseActivity.class, Neky.class,
            		Gunah.class, testSSB.class, Lagooh.class
            		)
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            // Deploy our test datasource
            .addAsWebInfResource("test-ds.xml", "test-ds.xml");
   }

   @Inject
   MemberRegistration memberRegistration;
   
   @Inject
   Logger log;
   
   @Test
   public void testRegister() throws Exception {
      Member newMember = memberRegistration.getNewMember();
      newMember.setName("Jane Doe");
      newMember.setEmail("jane@mailinator.com");
      newMember.setPhoneNumber("2125551234");
      memberRegistration.register();
      assertNotNull(newMember.getId());
      log.info(newMember.getName() + " was persisted with id " + newMember.getId());
      
//      testSSB testSSB = new testSSB();
//      testSSB.persist();
//      log.info("Persisted ");
   }
   
   //Adding @Stateless annotation eliminates the need for manual transaction demarcation
   @Stateful
   public static class testSSB {
	   
	   @Inject
	   private EntityManager em;
	   
	   public void persist(){
		   Day day = new Day();
		   Date date = new Date();
		   day.setDate(date);
		   
		   Neky neky = new Neky();
		   neky.setDay(day);
		   neky.setStartTime(date);
		   neky.setDescription("Offered qaza Namaz");
		   neky.setImprovementNote("Leave every thing at the time of namaz; but however if it is qaza then perform it at the first sigh of relief");
		   
		   Gunah gunah = new Gunah();
		   gunah.setDay(day);
		   gunah.setStartTime(date);
		   gunah.setDescription("Became leaked");
		   gunah.setRootCause("Lack of self control");
		   gunah.setRemedy("Always control yourself and look before you leap");
		   
		   day.getGoodDeeds().add(neky);
		   day.getBadDeeds().add(gunah);
		   em.persist(day);
	   }
   }
}