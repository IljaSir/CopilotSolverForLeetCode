class Solution {
    public int findPairs(int[] nums, int k) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0, j = 1, count = 0;
        while (i < nums.length && j < nums.length) {
            if (i == j || nums[j] - nums[i] < k) {
                j++;
            } else if (nums[j] - nums[i] > k) {
                i++;
            } else {
                count++;
                i++;
                while (i < nums.length && nums[i] == nums[i - 1]) {
                    i++;
                }
                j++;
            }
        }
        return count;
    }
}