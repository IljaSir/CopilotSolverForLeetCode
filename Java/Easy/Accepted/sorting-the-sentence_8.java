class Solution {
    public String sortSentence(String s) {
        
        String[] words = s.split(" ");
        String[] sortedWords = new String[words.length];
        for (String word : words) {
            int i = word.charAt(word.length() - 1) - '1';
            sortedWords[i] = word.substring(0, word.length() - 1);
        }
        return String.join(" ", sortedWords);
    }
}