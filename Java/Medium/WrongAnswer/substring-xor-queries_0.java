class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        
        int n = s.length();
        int[] prefix = new int[n];
        prefix[0] = s.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] ^ (s.charAt(i) - '0');
        }
        int[][] ans = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            int first = queries[i][0];
            int second = queries[i][1];

            int left = -1;
            int right = -1;
            for (int j = 0; j < n; j++) {
                int val = prefix[j] ^ first;
                if (val == second) {
                    left = j;
                    break;
                }
            }
            if (left != -1) {
                for (int j = n - 1; j >= 0; j--) {
                    int val = prefix[j] ^ first;
                    if (val == second) {
                        right = j;
                        break;
                    }
                }
            }
            ans[i][0] = left;
            ans[i][1] = right;
        }
        return ans;
    }
}