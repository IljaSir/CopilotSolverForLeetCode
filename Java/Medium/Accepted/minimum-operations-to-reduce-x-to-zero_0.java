class Solution {
    public int minOperations(int[] nums, int x) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x;
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return nums.length;
        }
        int left = 0;
        int right = 0;
        int max = -1;
        sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                max = Math.max(max, right - left);
            }
        }
        return max == -1 ? -1 : nums.length - max;
    }
}