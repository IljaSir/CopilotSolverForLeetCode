class Solution {
    public int[] productQueries(int n, int[][] queries) {
        
        int[] powers = new int[32];
        int[] ans = new int[queries.length];
        int p = 0;
        int i = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                powers[p] = i;
                p++;
            }
            i++;
            n /= 2;
        }
        int[] pow2 = new int[32];
        pow2[0] = 1;
        for (int j = 1; j < 32; j++) {
            pow2[j] = pow2[j - 1] * 2 % 1000000007;
        }
        for (int j = 0; j < queries.length; j++) {
            int l = queries[j][0];
            int r = queries[j][1];
            int pro = 1;
            for (int k = l; k <= r; k++) {
                pro = (int)(((long)pro * (long)pow2[powers[k] - powers[l]]) % 1000000007);
            }
            ans[j] = pro;
        }
        return ans;
    }
}