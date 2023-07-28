class Solution {
    public int mostWordsFound(String[] sentences) {
        
        int max = 0;
        for (String sentence : sentences) {
            int count = 0;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    count++;
                }
            }
            count++;
            max = Math.max(max, count);
        }
        return max;
    }
}