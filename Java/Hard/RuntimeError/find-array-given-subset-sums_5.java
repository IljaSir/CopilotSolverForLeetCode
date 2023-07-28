class Solution {
    public int[] recoverArray(int n, int[] sums) {
        
        int[] ans = new int[n];
        int[] sum = new int[1 << n];
        int[] cnt = new int[1 << n];
        for (int i = 0; i < sums.length; i++) {
            sum[sums[i] + 10000]++;
        }
        int[] a = new int[1 << n];
        int[] b = new int[1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                if ((j & (1 << i)) > 0) {
                    a[j] = a[j ^ (1 << i)] + sum[j];
                }
            }
            for (int j = 0; j < (1 << n); j++) {
                if ((j & (1 << i)) > 0) {
                    b[j] = b[j ^ (1 << i)] + a[j];
                }
            }
            for (int j = 0; j < (1 << n); j++) {
                if ((j & (1 << i)) > 0) {
                    cnt[j] = b[j ^ (1 << i)];
                }
            }
        }
        for (int i = 0; i < (1 << n); i++) {
            if (cnt[i] > 0) {
                ans[Integer.bitCount(i)] = i - 10000;
            }
        }
        return ans;
    }
}