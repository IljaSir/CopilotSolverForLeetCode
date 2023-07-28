class Solution {
    public int[] secondGreaterElement(int[] nums) {
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int secondGreater = -1;
            while (j < nums.length) {
                if (nums[j] > nums[i]) {
                    secondGreater = nums[j];
                    break;
                }
                j++;
            }
            result[i] = secondGreater;
        }
        return result;
    }
}