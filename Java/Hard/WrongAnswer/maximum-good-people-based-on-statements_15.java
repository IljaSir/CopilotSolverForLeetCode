class Solution {
    public int maximumGood(int[][] statements) {
        
        int n = statements.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (statements[i][j] == 0) {
                    ans[i] |= 1 << j;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 1 << n; ++i) {
            boolean ok = true;
            for (int j = 0; j < n; ++j) {
                if ((i & ans[j]) == 0 && ((i >> j) & 1) == 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                res = Math.max(res, Integer.bitCount(i));
            }
        }
        return res;
    }
}