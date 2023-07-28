class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        int index = 1;
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (word.startsWith(searchWord)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}