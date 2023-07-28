class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        
        int n = s.length();
        int[] xor = new int[n];
        xor[0] = s.charAt(0) - '0';
        for (int i = 1; i < n; ++i) {
            xor[i] = xor[i - 1] ^ (s.charAt(i) - '0');
        }
        int m = queries.length;
        int[][] ans = new int[m][2];
        for (int i = 0; i < m; ++i) {
            int first = queries[i][0];
            int second = queries[i][1];
            int lo = 0;
            int hi = n - 1;
            int left = -1;
            int right = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int val = xor[mid];
                if (mid > 0) {
                    val ^= xor[mid - 1];
                }
                if ((val ^ first) == second) {
                    left = mid;
                    hi = mid - 1;
                } else if ((val ^ first) > second) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (left == -1) {
                ans[i][0] = -1;
                ans[i][1] = -1;
                continue;
            }
            lo = left;
            hi = n - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int val = xor[mid];
                if (mid > 0) {
                    val ^= xor[mid - 1];
                }
                if ((val ^ first) == second) {
                    right = mid;
                    lo = mid + 1;
                } else if ((val ^ first) > second) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            ans[i][0] = left;
            ans[i][1] = right;
        }
        return ans;
    }
}