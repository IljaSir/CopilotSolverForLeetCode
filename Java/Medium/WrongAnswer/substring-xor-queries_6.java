class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        
        int n = s.length();
        int[][] ans = new int[queries.length][2];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }
        int[] dp = new int[n];
        dp[0] = a[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] ^ a[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int l = -1, r = -1;
            for (int j = 0; j < n; j++) {
                if ((dp[j] ^ q[0]) == q[1]) {
                    l = j;
                    break;
                }
            }
            if (l == -1) {
                ans[i][0] = -1;
                ans[i][1] = -1;
                continue;
            }
            for (int j = n - 1; j >= l; j--) {
                if ((dp[j] ^ q[0]) == q[1]) {
                    r = j;
                    break;
                }
            }
            ans[i][0] = l;
            ans[i][1] = r;
        }
        return ans;
    }
}