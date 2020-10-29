package Dictionary;

import java.lang.String;
public class Word {
	String word_target;
	String word_explain;
	
	public void setWord_target(String s) {
		s = s.trim();
		word_target = s;
	}
	
	public void setWord_explain(String s) {
		s = s.trim();
		String temp[] = s.split("\n");
		s = new String();
		for (int i = 0; i < temp.length; ++i) {
			temp[i] = temp[i].trim();
			s = s.concat(temp[i] + " ");
		}
		word_explain = s;
	}
	
	public String getWord_target() {
		
		return this.word_target;
	}
	
	public String getWord_explain() {
		return this.word_explain;
	}
	
	public Word(String word_target, String word_explain){
		this.setWord_explain(word_explain);
		this.setWord_target(word_target);
	}
}

