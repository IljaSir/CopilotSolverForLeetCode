class Solution {
    public String findTheString(int[][] lcp) {
        
        int n = lcp.length;
        if (n == 1) {
            return "a";
        }
        char[] ans = new char[n];
        ans[0] = 'a';
        ans[1] = (char) ('a' + lcp[0][1]);
        for (int i = 2; i < n; i++) {
            ans[i] = (char) (ans[i - 1] + lcp[i - 1][i] - lcp[i - 2][i]);
        }
        return new String(ans);
    }
}