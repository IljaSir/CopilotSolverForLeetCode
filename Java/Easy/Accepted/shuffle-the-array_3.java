class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int[] result = new int[nums.length];
        for (int i = 0, j = 0; i < nums.length; i += 2, j++) {
            result[i] = nums[j];
            result[i + 1] = nums[j + n];
        }
        return result;
    }
}