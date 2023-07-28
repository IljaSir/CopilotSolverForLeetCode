class Solution {
    public String findTheString(int[][] lcp) {
        
        int n = lcp.length;
        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            res[i] = 'a';
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] == n) {
                    return "";
                }
                res[j] = (char) Math.max(res[j], res[i] + lcp[i][j]);
            }
        }
        return new String(res);
    }
}