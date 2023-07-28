class Solution {
    public int mostWordsFound(String[] sentences) {
        
        int maxCount = 0;
        for(String sentence : sentences) {
            String[] words = sentence.split(" ");
            maxCount = Math.max(maxCount, words.length);
        }
        return maxCount;
    }
}