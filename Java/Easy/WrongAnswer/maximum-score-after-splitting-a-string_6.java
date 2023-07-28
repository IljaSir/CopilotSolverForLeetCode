class Solution {
    public int maxScore(String s) {
        
        int n = s.length();
        int max = 0;
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros--;
            } else {
                ones--;
            }
            max = Math.max(max, zeros + ones);
        }
        return max;
    }
}