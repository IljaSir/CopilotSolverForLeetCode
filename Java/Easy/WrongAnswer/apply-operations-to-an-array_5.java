class Solution {
    public int[] applyOperations(int[] nums) {
        
        int[] result = new int[nums.length];
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                result[j++] = nums[i++];
            } else {
                result[j++] = nums[i] * 2;
                i += 2;
            }
        }
        return result;
    }
}