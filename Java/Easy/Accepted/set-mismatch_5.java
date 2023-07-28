class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int[] arr = new int[nums.length];
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i] - 1] == 1) {
                ret[0] = nums[i];
            } else {
                arr[nums[i] - 1] = 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] == 0) {
                ret[1] = i + 1;
            }
        }
        return ret;
    }
}