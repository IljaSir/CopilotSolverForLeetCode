class Solution {
    public int maxScore(int[] nums) {
        
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prefix[i] > 0) {
                max++;
            }
        }
        return max;
    }
}