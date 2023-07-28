class Solution {
    public int longestPath(int[] parent, String s) {
        
        int n = parent.length;
        int[] dp = new int[n];
        int[] count = new int[26];
        int[] children = new int[n];
        for (int i = 0; i < n; i++) {
            children[parent[i]]++;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (children[i] == 0) {
                dp[i] = 1;
                count[s.charAt(i) - 'a']++;
            } else {
                int max = 0;
                for (int j = 0; j < 26; j++) {
                    if (count[j] > 0) {
                        max = Math.max(max, count[j]);
                        count[j] = 0;
                    }
                }
                dp[i] = max + 1;
                count[s.charAt(i) - 'a']++;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}