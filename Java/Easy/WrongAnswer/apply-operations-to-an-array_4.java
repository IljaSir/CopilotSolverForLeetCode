class Solution {
    public int[] applyOperations(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                result[index++] = nums[i];
            } else {
                result[index++] = nums[i] * 2;
                i++;
            }
        }
        if (index < n) {
            result[index] = nums[n - 1];
        }
        return result;
    }
}