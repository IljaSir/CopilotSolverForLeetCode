class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int n = nums.length;
        int[] avgs = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            avgs[i] = (i < k - 1) ? -1 : sum / k;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            if (i < n - k) {
                sum -= nums[i + k];
            }
            avgs[i] = (i > n - k) ? -1 : Math.max(avgs[i], sum / k);
        }
        return avgs;
    }
}