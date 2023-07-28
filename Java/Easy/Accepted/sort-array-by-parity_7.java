class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int[] result = new int[nums.length];
        int start = 0, end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[start] = nums[i];
                start++;
            } else {
                result[end] = nums[i];
                end--;
            }
        }
        return result;
    }
}