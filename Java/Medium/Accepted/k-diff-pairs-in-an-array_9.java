class Solution {
    public int findPairs(int[] nums, int k) {
        
        if (nums.length == 0 || k < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0, right = 0, count = 0;
        while (left < nums.length) {
            right = Math.max(right, left + 1);
            while (right < nums.length && nums[right] - nums[left] < k) {
                right++;
            }
            if (right < nums.length && nums[right] - nums[left] == k) {
                count++;
            }
            while (left + 1 < nums.length && nums[left] == nums[left + 1]) {
                left++;
            }
            left++;
        }
        return count;
    }
}