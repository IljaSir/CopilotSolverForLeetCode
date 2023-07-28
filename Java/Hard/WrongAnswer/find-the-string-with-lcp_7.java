class Solution {
    public String findTheString(int[][] lcp) {
        
        int n = lcp.length;
        int[] lcp2 = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lcp2[i] = Math.max(lcp2[i], lcp[i][j]);
            }
        }
        int[] lcp3 = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lcp3[i] = Math.max(lcp3[i], lcp[j][i]);
            }
        }
        int[] lcp4 = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lcp4[i] = Math.max(lcp4[i], lcp[j][n - 1 - i]);
            }
        }
        int[] lcp5 = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lcp5[i] = Math.max(lcp5[i], lcp[n - 1 - i][j]);
            }
        }
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            char c = 'a';
            for (int j = 0; j < n; j++) {
                if (lcp2[i] == n - i - 1 && lcp3[j] == i && lcp4[j] == n - i - 1 && lcp5[i] == j) {
                    c = (char) Math.max(c, j + 'a');
                }
            }
            ans[i] = c;
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == 'a' + n) {
                return "";
            }
        }
        return new String(ans);
    }
}