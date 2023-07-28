class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        // check if sentences are equal
        if(sentence1.equals(sentence2)) {
            return true;
        }
        // split sentences into words
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        // check if sentence1 is shorter than sentence2
        if(words1.length < words2.length) {
            // check for similarity
            return isSimilar(words1, words2);
        } else {
            // check for similarity
            return isSimilar(words2, words1);
        }
    }
    
    // check for similarity
    private boolean isSimilar(String[] words1, String[] words2) {
        int i = 0;
        int j = 0;
        while(i < words1.length && j < words2.length) {
            // check if words are equal
            if(words1[i].equals(words2[j])) {
                i++;
                j++;
            } else {
                // check if words are similar
                if(i == 0) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}