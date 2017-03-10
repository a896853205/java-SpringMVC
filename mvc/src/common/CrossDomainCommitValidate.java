package common;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class CrossDomainCommitValidate {
	
	public static boolean validate(HttpServletRequest request) {
		String Referer = "";
		boolean referer_sign = true; 
		Enumeration headerValues = request.getHeaders("Referer");
		while (headerValues.hasMoreElements())
			Referer = (String) headerValues.nextElement();

		if (Referer == null || Referer.length() < 1)
			referer_sign = false;
		else {

			String servername_str = request.getServerName();
			if (servername_str != null || servername_str.length() > 0) {
				int index = 0;
				if (StringUtils.indexOf(Referer, "https://") == 0) {
					index = 8;
				} else if (StringUtils.indexOf(Referer, "http://") == 0) {
					index = 7;
				}
				if (Referer.length() - index < servername_str.length()) 
					referer_sign = false;
				else { 
					String referer_str = Referer.substring(index, index + servername_str.length());
					if (!servername_str.equalsIgnoreCase(referer_str))
						referer_sign = false;
				}
			} else
				referer_sign = false;
		}
		return referer_sign;
	}
	
}
