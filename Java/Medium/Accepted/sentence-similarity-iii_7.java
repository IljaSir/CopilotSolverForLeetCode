class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
        if (sentence1.equals(sentence2)) return true;
        if (sentence1.length() > sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0;
        for (; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])) {
                break;
            }
        }
        int j = 0;
        for (; j < words1.length - i; j++) {
            if (!words1[words1.length - j - 1].equals(words2[words2.length - j - 1])) {
                break;
            }
        }
        return i + j >= words1.length;
    }
}