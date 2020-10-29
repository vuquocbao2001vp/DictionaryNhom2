package translate;

import com.darkprograms.speech.translator.*;

public class Google {
	public static int maxLength = 30;
	
	public static String translate(String eng) {
		String vie = new String(); 
		try {
			while (eng != null && !eng.isEmpty()) {
				eng = eng.trim();
				int pos = eng.indexOf('\n');
				String temp;
				if (pos == -1) {
					temp = GoogleTranslate.translate("en", "vi", eng);
					eng = null;
				} else {
					temp = GoogleTranslate.translate("en", "vi", eng.substring(0, pos-1));
					if (pos != eng.length()) {
						eng = eng.substring(pos+1);
					} else {
						eng = null;
					}
				}
				
				vie = vie.concat(temp + "\n");
			}
			
			return vie;
		}
		
		catch (Exception e) {
			return new String();
		}
	}
}
;