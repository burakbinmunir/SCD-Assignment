import java.util.*;
public class StopWords {

    private ArrayList<String> stopWords;
    private HashMap<String,Integer> stopMap;

    StopWords(){
        stopWords = new ArrayList<String>();
        stopMap = new HashMap<String,Integer>();
    }

    void addStopWord(String stopWord){
        stopWords.add(stopWord);
    }

    void findStopWords(String story){

        for(String stpWrd : stopWords){
            int count = 0;
            StringTokenizer sT = new StringTokenizer(story, " ");

            while( sT.hasMoreElements()) {


                String str =sT.nextToken();
                if (str.equals(stpWrd)) {
                    count++;
                }

            }

            if (count > 0){
                stopMap.put(stpWrd,count);
            }
        }


    }

    void print() {
       for(String stopWord: stopWords){
           System.out.println("Word: " + stopWord+ " " + stopMap.get(stopWord));
       }
    }

    public static void main(String[] args) {
        StopWords sw = new StopWords();
        sw.addStopWord("was");
        sw.addStopWord("He");
        sw.findStopWords("He was was happy");
        sw.print();
    }
}
