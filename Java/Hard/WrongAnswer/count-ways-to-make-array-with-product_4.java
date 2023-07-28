class Solution {
    public int[] waysToFillArray(int[][] queries) {
        
        int M = 1000000007;
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int k = queries[i][1];
            int[] f = new int[k + 1];
            for (int j = 1; j <= k; j++) {
                f[j] = j;
            }
            for (int j = 2; j <= n; j++) {
                for (int l = k; l >= 1; l--) {
                    for (int m = 1; m <= k; m++) {
                        if (m * l > k) {
                            break;
                        }
                        f[m * l] = (f[m * l] + f[l]) % M;
                    }
                }
            }
            result[i] = f[k];
        }
        return result;
    }
}