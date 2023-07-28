class Solution {
    public int maxScore(String s) {
        
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneCount++;
            }
        }
        int maxScore = 0;
        int zeroCount = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount--;
            }
            maxScore = Math.max(maxScore, zeroCount + oneCount);
        }
        return maxScore;
    }
}