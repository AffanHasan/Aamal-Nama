package org.jboss.as.quickstarts.kitchensink.test;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.as.quickstarts.kitchensink.controller.MemberRegistration;
import org.jboss.as.quickstarts.kitchensink.model.BaseActivity;
import org.jboss.as.quickstarts.kitchensink.model.BaseEntity;
import org.jboss.as.quickstarts.kitchensink.model.Day;
import org.jboss.as.quickstarts.kitchensink.model.General;
import org.jboss.as.quickstarts.kitchensink.model.Lagooh;
import org.jboss.as.quickstarts.kitchensink.model.Member;
import org.jboss.as.quickstarts.kitchensink.model.enums.FarzNamazHealthCategory;
import org.jboss.as.quickstarts.kitchensink.model.enums.NamazNames;
import org.jboss.as.quickstarts.kitchensink.model.gunah.Gunah;
import org.jboss.as.quickstarts.kitchensink.model.gunah.UncategorizedGunah;
import org.jboss.as.quickstarts.kitchensink.model.gunah.haqooqAllah.namaz.QazaFarzNamaz;
import org.jboss.as.quickstarts.kitchensink.model.neky.Neky;
import org.jboss.as.quickstarts.kitchensink.model.neky.UncategorizedNeky;
import org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah.HaqooqAllah;
import org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah.namaz.FarzNamaz;
import org.jboss.as.quickstarts.kitchensink.model.neky.haqooqAllah.namaz.Namaz;
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
            		Gunah.class, Lagooh.class,
            		General.class, HaqooqAllah.class, Namaz.class, FarzNamaz.class, NamazNames.class
            		,FarzNamazHealthCategory.class,
            		UncategorizedGunah.class, UncategorizedNeky.class
            		, org.jboss.as.quickstarts.kitchensink.model.gunah.haqooqAllah.HaqooqAllah.class
            		, org.jboss.as.quickstarts.kitchensink.model.gunah.haqooqAllah.namaz.Namaz.class
            		, QazaFarzNamaz.class
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
      memberRegistration.register(2L);
//      assertNotNull(newMember.getId());
      memberRegistration.register(3L);
      log.info(newMember.getName() + " was persisted with id " + newMember.getId());
   }
}