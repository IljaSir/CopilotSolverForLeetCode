class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        long sum = 0;
        int ans = 1;
        for (int j = 1; j < n; ++j) {
            sum += (long) (nums[j] - nums[j - 1]) * (j - i);
            while (sum > k) {
                sum -= nums[j] - nums[i];
                ++i;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}