class Solution {
    public int maxScore(String s) {
        
        int maxScore = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                left++;
            } else {
                right++;
            }
            maxScore = Math.max(maxScore, left + (s.length() - i - 1 - right));
        }
        return maxScore;
    }
}