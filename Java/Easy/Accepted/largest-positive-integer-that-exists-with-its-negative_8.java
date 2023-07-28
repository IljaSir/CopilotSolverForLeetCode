class Solution {
    public int findMaxK(int[] nums) {
        
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
        if (max < 0 || min > 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] == -nums[j]) {
                return nums[j];
            } else if (nums[i] < -nums[j]) {
                i++;
            } else {
                j--;
            }
        }
        return -1;
    }
}