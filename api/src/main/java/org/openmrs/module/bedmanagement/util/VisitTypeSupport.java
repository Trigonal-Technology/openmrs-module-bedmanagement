package org.openmrs.module.bedmanagement.util;

import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.openmrs.VisitType;

/**
 * Utility methods for classifying visit types used by bed assignment rules.
 */
public final class VisitTypeSupport {
	
	private static final Pattern NON_ALPHANUM = Pattern.compile("[^A-Z0-9]");
	
	private VisitTypeSupport() {
	}
	
	public static boolean isErOrIpdVisitType(VisitType visitType) {
		if (visitType == null || StringUtils.isBlank(visitType.getName())) {
			return false;
		}
		return isErOrIpdVisitTypeName(visitType.getName());
	}
	
	public static boolean isErOrIpdVisitTypeName(String visitTypeName) {
		if (StringUtils.isBlank(visitTypeName)) {
			return false;
		}
		
		String normalized = normalizeVisitTypeName(visitTypeName);
		if ("ER".equals(normalized) || "IPD".equals(normalized)) {
			return true;
		}
		if (normalized.startsWith("ER") || normalized.contains("EMERGENCY")) {
			return true;
		}
		return normalized.startsWith("IPD") || normalized.contains("INPATIENT");
	}
	
	private static String normalizeVisitTypeName(String visitTypeName) {
		String upper = visitTypeName.trim().toUpperCase(Locale.ROOT);
		return NON_ALPHANUM.matcher(upper).replaceAll("");
	}
}
