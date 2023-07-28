class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        
        int n = arr.length;
        long[] sums = new long[n];
        for (int i = 0; i < n; i++) {
            sums[i] = arr[i] + (i > 0 ? sums[i - 1] : 0);
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long sum = sums[i] - (i >= k ? sums[i - k] : 0);
            ans = Math.min(ans, Math.abs((sums[n - 1] - sum) - sum));
        }
        return ans;
    }
}