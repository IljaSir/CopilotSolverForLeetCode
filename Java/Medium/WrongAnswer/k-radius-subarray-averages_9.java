class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int[] averages = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i <= k) {
                sum += nums[i];
                if(i == k) {
                    averages[i - k] = sum / (k + 1);
                }
            } else if(i > k && i < nums.length - k) {
                sum += nums[i];
                sum -= nums[i - k - 1];
                averages[i - k] = sum / (2 * k + 1);
            } else if(i >= nums.length - k) {
                sum -= nums[i - k - 1];
                averages[i - k] = sum / (nums.length - i + k);
            }
        }
        return averages;
    }
}