class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        String[] words = sentence.split(" ");
        int index = 1;
        for (String word : words) {
            if (word.startsWith(searchWord)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}