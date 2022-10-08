import java.util.*;
public class StopWords {

    private String[] stopWords;
    private HashMap<String,Integer> stopMap;

    StopWords(){
        stopWords = new String[]{"was", "has"};
        stopMap = new HashMap<String,Integer>();
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

    void print(){
        for (int i=0 ; i < stopMap.size(); i++){
           System.out.println("Stop word: " + /*stop word*/ + stopMap.get("was"));
        }
    }

    public static void main(String[] args) {
        StopWords sw = new StopWords();
        sw.findStopWords("He was was happy");
        sw.print();
    }
}
