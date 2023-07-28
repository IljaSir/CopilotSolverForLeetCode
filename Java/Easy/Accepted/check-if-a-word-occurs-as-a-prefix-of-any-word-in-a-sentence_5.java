class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        
        int index = 0;
        String[] words = sentence.split(" ");
        for (String word : words) {
            index++;
            if (word.startsWith(searchWord)) {
                return index;
            }
        }
        return -1;
    }
}