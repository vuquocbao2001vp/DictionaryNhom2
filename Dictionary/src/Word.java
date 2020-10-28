import java.lang.String;
public class Word {
        String word_target;
        String word_explain;
        public void setWord_target(String s) {
            word_target = s;
        }
        public void setWord_explain(String s) {
            word_explain = s;
        }
        public String getWord_target() {
            return this.word_target;
        }
        public String getWord_explain() {
            return this.word_explain;
        }
        public Word(String word_target, String word_explain){
            this.word_explain = word_explain;
            this.word_target = word_target;
        }
}

