class Solution {
    public long sumScores(String s) {
        
        long sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt(n - 1)) {
                sum += n - i;
            }
        }
        return sum;
    }
}