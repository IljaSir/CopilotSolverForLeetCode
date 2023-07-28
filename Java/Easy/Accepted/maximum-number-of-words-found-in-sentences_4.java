class Solution {
    public int mostWordsFound(String[] sentences) {
        
        if (sentences == null || sentences.length == 0) {
            return 0;
        }
        int max = 0;
        for (String sentence : sentences) {
            max = Math.max(max, sentence.split(" ").length);
        }
        return max;
    }
}