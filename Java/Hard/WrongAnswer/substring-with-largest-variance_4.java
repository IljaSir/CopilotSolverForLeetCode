class Solution {
    public int largestVariance(String s) {
        
        int n = s.length();
        int[][] count = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                count[i][j] = i > 0 ? count[i - 1][j] : 0;
            }
            count[i][s.charAt(i) - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int min = 0;
                int max = 0;
                for (int k = 0; k < 26; k++) {
                    int cur = count[j][k] - (i > 0 ? count[i - 1][k] : 0);
                    min = Math.min(min, cur);
                    max = Math.max(max, cur);
                }
                ans = Math.max(ans, max - min);
            }
        }
        return ans;
    }
}