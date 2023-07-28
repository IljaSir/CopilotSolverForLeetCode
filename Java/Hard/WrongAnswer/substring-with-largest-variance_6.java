class Solution {
    public int largestVariance(String s) {
        
        int n = s.length();
        int[][] a = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                a[i][j] = (i > 0 ? a[i - 1][j] : 0) + (s.charAt(i) - 'a' == j ? 1 : 0);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int max = 0;
                int min = j - i + 1;
                for (int k = 0; k < 26; k++) {
                    int x = a[j][k] - (i > 0 ? a[i - 1][k] : 0);
                    max = Math.max(max, x);
                    min = Math.min(min, x);
                }
                ans = Math.max(ans, max - min);
            }
        }
        return ans;
    }
}