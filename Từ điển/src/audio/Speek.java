package audio;

import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class Speek {
	private static Synthesizer synthesizer;
	
	static {
		try {
            System.setProperty( "freetts.voices",  "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");
            Central.registerEngineCentral( "com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral");
            synthesizer = Central.createSynthesizer( new SynthesizerModeDesc(Locale.US)); 
	        synthesizer.allocate();
        } 
  
        catch (Exception e) { 
            System.out.println("Loi khi khoi tao freeTTS");
        } 
	}
	
	public static void speek(String eng) {
		try { 
	        synthesizer.resume();
	        int pos;
	        while ( (pos = eng.indexOf('\n')) != -1) {
	        	synthesizer.speakPlainText(eng.substring(0, pos-1), null);
	        	eng = eng.substring(pos+1);
	        }
	        synthesizer.speakPlainText(eng, null); 
	        synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY); 
	        synthesizer.pause();
		}
		
		catch (Exception e) { 
            System.out.println("Loi khi chay freeTTS");
        } 
	}
}
