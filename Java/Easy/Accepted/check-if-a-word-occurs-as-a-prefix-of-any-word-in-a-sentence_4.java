class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        String[] words = sentence.split(" ");
        int len = searchWord.length();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < len) continue;
            if (words[i].substring(0, len).equals(searchWord)) return i + 1;
        }
        return -1;
    }
}