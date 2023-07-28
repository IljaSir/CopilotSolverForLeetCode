class Solution {
    public int maxScore(int[] nums) {
        
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (prefix[i - 1] > 0) {
                max = Math.max(max, prefix[i - 1] + suffix[i]);
            }
        }
        return max;
    }
}