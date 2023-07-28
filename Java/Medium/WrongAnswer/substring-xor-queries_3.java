class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        
        int n = s.length();
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] ^ (s.charAt(i) - '0');
        }
        int[][] res = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int v = prefix[q[0]] ^ q[1];
            int l = q[0];
            int r = n;
            while (l < r) {
                int m = l + (r - l) / 2;
                if ((prefix[m+1] ^ prefix[q[0]]) == v) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (l == n) {
                res[i] = new int[]{-1, -1};
            } else {
                res[i] = new int[]{q[0], l};
            }
        }
        return res;
    }
}