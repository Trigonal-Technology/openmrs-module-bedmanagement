package org.openmrs.module.bedmanagement.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VisitTypeSupportTest {
	
	@Test
	public void shouldAcceptErAndIpdAliases() {
		assertTrue(VisitTypeSupport.isErOrIpdVisitTypeName("ER"));
		assertTrue(VisitTypeSupport.isErOrIpdVisitTypeName("Emergency"));
		assertTrue(VisitTypeSupport.isErOrIpdVisitTypeName("Emergency Visit"));
		assertTrue(VisitTypeSupport.isErOrIpdVisitTypeName("IPD"));
		assertTrue(VisitTypeSupport.isErOrIpdVisitTypeName("Inpatient"));
		assertTrue(VisitTypeSupport.isErOrIpdVisitTypeName("In-Patient Department"));
	}
	
	@Test
	public void shouldRejectNonErOrIpdVisitTypes() {
		assertFalse(VisitTypeSupport.isErOrIpdVisitTypeName(null));
		assertFalse(VisitTypeSupport.isErOrIpdVisitTypeName(""));
		assertFalse(VisitTypeSupport.isErOrIpdVisitTypeName("OPD"));
		assertFalse(VisitTypeSupport.isErOrIpdVisitTypeName("Outpatient"));
	}
}
