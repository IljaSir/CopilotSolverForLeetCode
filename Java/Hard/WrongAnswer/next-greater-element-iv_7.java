class Solution {
    public int[] secondGreaterElement(int[] nums) {
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int j = i + 1;
            for (; j < nums.length; j++) {
                if (nums[j] > num) {
                    result[i] = nums[j];
                    break;
                }
            }
            if (j == nums.length) {
                result[i] = -1;
            }
        }
        return result;
    }
}