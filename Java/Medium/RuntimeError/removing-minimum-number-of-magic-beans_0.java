class Solution {
    public long minimumRemoval(int[] beans) {
        
        int n = beans.length;
        long[] sum = new long[n];
        sum[0] = beans[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + beans[i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                long cur = sum[j] - (i == 0 ? 0 : sum[i - 1]);
                if (cur % (j - i + 1) == 0) {
                    min = Math.min(min, cur / (j - i + 1) * (i) - (i == 0 ? 0 : sum[i - 1]));
                }
            }
            ans = Math.min(ans, min);
        }
        return ans;
    }
}