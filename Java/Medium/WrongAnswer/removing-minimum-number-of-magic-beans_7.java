class Solution {
    public long minimumRemoval(int[] beans) {
        
        long ans = Long.MAX_VALUE;
        int n = beans.length;
        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            pre[i] = pre[i - 1] + beans[i - 1];
        }
        for (int i = 1; i <= n; ++i) {
            long l = 0, r = beans[i - 1];
            while (l < r) {
                long m = l + r >> 1;
                long sum = pre[i] + m;
                if (sum % (i + 1) == 0) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            long sum = pre[i] + l;
            if (sum % (i + 1) == 0) {
                ans = Math.min(ans, l);
            }
        }
        return ans;
    }
}