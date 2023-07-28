class Solution {
    public int findPairs(int[] nums, int k) {
        
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int index = Arrays.binarySearch(nums, i + 1, nums.length, nums[i] + k);
            if (index >= 0) {
                count++;
            }
        }
        return count;
    }
}