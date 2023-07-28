class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        
        int n = s.length();
        int[][] ans = new int[queries.length][2];
        int[] prefix = new int[n];
        prefix[0] = s.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] ^ (s.charAt(i) - '0');
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i][0] = -1;
            ans[i][1] = -1;
            int first = queries[i][0];
            int second = queries[i][1];
            for (int j = 0; j < n; j++) {
                int xor = first;
                if (j > 0) {
                    xor ^= prefix[j - 1];
                }
                if (xor == second) {
                    ans[i][0] = j;
                }
                if (ans[i][0] != -1 && prefix[j] == second) {
                    ans[i][1] = j;
                    break;
                }
            }
        }
        return ans;
    }
}