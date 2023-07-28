class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        int left = 0;
        long sum = 0;
        int res = 1;
        for (int right = 1; right < nums.length; right++) {
            sum += (long)(nums[right] - nums[right - 1]) * (right - left);
            while (sum > k) {
                sum -= nums[right] - nums[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}