class Solution {
    public String findTheString(int[][] lcp) {
        
        int n = lcp.length;
        int[] cnt = new int[n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt[lcp[i][j]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            if (cnt[i] == i * i) {
                return build(n, i, lcp);
            }
        }
        return "";
    }
    String build(int n, int len, int[][] lcp) {
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                ans[i] = c;
                if (check(len, ans, lcp)) {
                    break;
                }
            }
        }
        return new String(ans);
    }
    boolean check(int len, char[] ans, int[][] lcp) {
        int n = ans.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] == len) {
                    if (ans[i] != ans[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}