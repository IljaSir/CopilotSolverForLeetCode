class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res[0] = Math.abs(nums[i]);
            } else {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
            }
        }
        return res;
    }
}