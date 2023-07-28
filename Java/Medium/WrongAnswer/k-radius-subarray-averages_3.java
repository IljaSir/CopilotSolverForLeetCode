class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int n = nums.length;
        int[] avgs = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i <= k) {
                sum += nums[i];
                avgs[i] = i == k ? sum / (k + 1) : -1;
            } else if (i <= n - k - 1) {
                sum += nums[i];
                sum -= nums[i - k - 1];
                avgs[i] = sum / (k + 1);
            } else {
                sum -= nums[i - k - 1];
                avgs[i] = -1;
            }
        }
        return avgs;
    }
}