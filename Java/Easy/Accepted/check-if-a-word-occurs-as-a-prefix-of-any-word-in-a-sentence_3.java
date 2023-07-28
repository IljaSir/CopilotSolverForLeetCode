class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        String[] words = sentence.split(" ");
        int index = 0;
        for (String word : words) {
            if (word.startsWith(searchWord)) {
                return index + 1;
            }
            index++;
        }
        return -1;
    }
}