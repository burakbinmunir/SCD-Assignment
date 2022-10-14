import java.util.*;
public class StopWords {
    /*
    * This class finds the stop words from the given text
    * and store the count against the stop words in hashmap
    * */


    private ArrayList<String> stopWords;
    private HashMap<String,Integer> stopMap;
    private String story;

    StopWords(){
        story = "";
        stopWords = new ArrayList<String>();
        stopMap = new HashMap<String,Integer>();
        // initlialzed the array of stop words
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

        stopWords.addAll(Arrays.asList(arr)); // setting all of the stop words in arraylist
    }

    // prints the all of stop words
    void printStopWord(){
        for (String stopWord : stopWords){
            System.out.println(stopWord);
        }
    }

    // this function returns true if the given character is not
    // a punctuation character else returns false
    boolean checkPunctuation(char character){
        if (character == ',' ||character == '.' ||
                character == '"' ||character == '\'' ||
                character == '?')
        {
            return false;
        }
        else {
            return true;
        }
    }

    // sets the story excluding the punctuation
    void setStory(String story){
       for (int index =0; index < story.length(); index++){
           if (checkPunctuation(story.charAt(index)))
           {
               this.story = this.story + story.charAt(index);
           }
       }
    }

    // prints the saved story
    void tellStory(){
        System.out.println(story);
    }

    // this function counts the stop words
    // and set the count against the key(stopword) in hashmap
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

    // prints the count of all stop words
    void printAllStopWordsCount() {
        for (String stopWord: stopWords){
            Integer count = stopMap.get(stopWord);
            if (count == null) {
                System.out.println(stopWord + " " + 0);
            }
            else {
                System.out.println(stopWord + " " + count);
            }
        }
    }

    // prints the count of stop words which are
    // present only in story
    void printOnlyStopWordsCount(){
           for (String stopWord: stopWords){
            Integer count = stopMap.get(stopWord);
            if (count != null) {
                System.out.println(stopWord + " " + count);
            }
        }
    }

    public static void main(String[] args) {
        StopWords sw = new StopWords();
        String story;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your story: ");
        story = scanner.nextLine();
        sw.setStory(story);
        sw.findStopWords(story);
        //sw.printOnlyStopWordsCount();
        sw.printAllStopWordsCount();
    }
}
