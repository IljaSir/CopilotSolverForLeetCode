class Solution {
    public boolean isCircularSentence(String sentence) {
        
        String[] words = sentence.split(" ");
        if (words.length == 1) {
            return true;
        }
        int i = 0;
        for (; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                return false;
            }
        }
        return words[i].charAt(words[i].length() - 1) == words[0].charAt(0);
    }
}