class Solution {
    public int maximumDifference(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[j]);
                }
            }
        }
        return max - min > 0 ? max - min : -1;
    }
}