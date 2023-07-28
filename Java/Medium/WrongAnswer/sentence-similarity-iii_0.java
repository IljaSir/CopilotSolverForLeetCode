class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        if (sentence1.equals(sentence2)) {
            return true;
        }
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        if (words1.length < words2.length) {
            String[] temp = words1;
            words1 = words2;
            words2 = temp;
        }
        int i = 0;
        while (i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        int j = words1.length - 1;
        int k = words2.length - 1;
        while (j >= i && k >= i && words1[j].equals(words2[k])) {
            j--;
            k--;
        }
        return j < i;
    }
}