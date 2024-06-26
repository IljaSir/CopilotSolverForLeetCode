class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i - j + 1);
                sum -= nums[j];
                j++;
            }
            i++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}