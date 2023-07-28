class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int[] avgs = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= k) {
                sum += nums[i];
                if (i == k) {
                    avgs[i] = sum / (k + 1);
                }
            } else if (i >= nums.length - k) {
                avgs[i] = -1;
            } else {
                sum += nums[i];
                sum -= nums[i - k - 1];
                avgs[i] = sum / (k + 1);
            }
        }
        return avgs;
    }
}