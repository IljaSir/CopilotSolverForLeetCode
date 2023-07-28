class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        if (sentence1.equals(sentence2)) {
            return true;
        }
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0;
        int j = 0;
        while (i < words1.length && j < words2.length) {
            if (words1[i].equals(words2[j])) {
                i++;
                j++;
            } else {
                break;
            }
        }
        while (i < words1.length && j < words2.length) {
            if (words1[words1.length - (i + 1)].equals(words2[words2.length - (j + 1)])) {
                i++;
                j++;
            } else {
                break;
            }
        }
        return i == words1.length && j == words2.length;
    }
}