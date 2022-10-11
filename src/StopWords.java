import java.util.*;
public class StopWords {

    private ArrayList<String> stopWords;
    private HashMap<String,Integer> stopMap;
    private String story;

    StopWords(){
        story = "";
        stopWords = new ArrayList<String>();
        stopMap = new HashMap<String,Integer>();
        String[] arr={"i",
                "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your",
                "yours", "yourself", "yourselves", "he", "him", "his", "himself", "she",
                "her", "hers", "herself", "it", "its", "itself", "they", "them",
                "their", "theirs", "themselves", "what", "which", "who", "whom", "this",
                "that", "these", "those", "am", "is", "are", "was", "were", "be",
                "been", "being", "have", "has", "had", "having", "do", "does", "did",
                "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as",
                "until", "while", "of", "at", "by", "for", "with", "about", "against",
                "between", "into", "through", "during", "before", "after", "above",
                "below", "to", "from", "up", "down", "in", "out", "on", "off", "over",
                "under", "again", "further", "then", "once", "here", "there", "when",
                "where", "why", "how", "all", "any", "both", "each", "few", "more",
                "most", "other", "some", "such", "no", "nor", "not", "only", "own",
                "same", "so", "than", "too", "very", "s", "t", "can", "will", "just",
                "don", "should", "now"};

        stopWords.addAll(Arrays.asList(arr));
    }

    void printStopWord(){
        for (String stopWord : stopWords){
            System.out.println(stopWord);
        }
    }

    void setStory(String story){
       for (int index =0; index < story.length(); index++){
           if (story.charAt(index) != ',' ||story.charAt(index) != '.' ||
                   story.charAt(index) != '"' ||story.charAt(index) != '\'' ||
                   story.charAt(index) != '?');
           {
               this.story = this.story + story.charAt(index);
           }
       }
    }

    void tellStory(){
        System.out.println(story);
    }

    void findStopWords(String story){
        //this.story = story;
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

    void printAllStopWordsCount() {
       for(String stopWord: stopWords){
           System.out.println("Word: " + stopWord+ " " + stopMap.get(stopWord));
       }
    }

    void printOnlyStopWordsCount(){
       StringTokenizer str = new StringTokenizer(story," ");
       while(str.hasMoreTokens()){
          String token= str.nextToken();
          Integer count = stopMap.get(token);
          if (count == null) {
              System.out.println("Word: " + token + " " + 0);
          }
          else {
              System.out.println("Word: " + token + " " + count);
          }
       }
    }

    public static void main(String[] args) {
        StopWords sw = new StopWords();
        //String story = "Once upon a time, there lived a crow in a forest close to a town.";
        String story = ",.?'";
        sw.setStory(story);
        sw.tellStory();
        //sw.findStopWords(story);
        //sw.print();
        //sw.printOnlyStopWordsCount();
    }
}
