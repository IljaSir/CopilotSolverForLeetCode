class Solution {
    public long sumScores(String s) {
        
        long score = 0;
        int n = s.length();
        int[] prefix = new int[n];
        prefix[0] = 1;
        int maxPrefix = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = 1;
            }
            maxPrefix = Math.max(maxPrefix, prefix[i]);
        }
        for (int i = 0; i < n; i++) {
            score += Math.min(prefix[i], maxPrefix);
            maxPrefix = Math.max(maxPrefix - 1, 0);
        }
        return score;
    }
}