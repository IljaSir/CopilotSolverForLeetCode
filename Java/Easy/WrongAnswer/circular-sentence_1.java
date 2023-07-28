class Solution {
    public boolean isCircularSentence(String sentence) {
        
        String[] words = sentence.split(" ");
        return words[words.length - 1].charAt(0) == words[0].charAt(words[0].length() - 1);
    }
}