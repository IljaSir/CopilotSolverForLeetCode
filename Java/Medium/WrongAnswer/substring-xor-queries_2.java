class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        
        int[][] res = new int[queries.length][2];
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            dp[i] = dp[i - 1] ^ (s.charAt(i) - '0');
        }
        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            int idx = -1;
            for (int j = 0; j < s.length(); j++) {
                if (dp[j] == (first ^ second)) {
                    idx = j;
                    break;
                }
            }
            if (idx == -1) {
                res[i][0] = -1;
                res[i][1] = -1;
            } else {
                int left = idx;
                int right = idx;
                for (int j = idx; j >= 0; j--) {
                    if ((dp[j] ^ first) == second) {
                        left = j;
                    } else {
                        break;
                    }
                }
                for (int j = idx; j < s.length(); j++) {
                    if ((dp[j] ^ first) == second) {
                        right = j;
                    } else {
                        break;
                    }
                }
                res[i][0] = left;
                res[i][1] = right;
            }
        }
        return res;
    }
}