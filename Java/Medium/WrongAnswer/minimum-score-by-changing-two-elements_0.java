class Solution {
    public int minimizeSum(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = Math.min(0, nums[i] - min);
            suffix[i] = Math.max(0, nums[i] - max);
        }
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = Math.min(prefix[i], prefix[i - 1]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i], suffix[i + 1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            ans = Math.min(ans, Math.min(0, suffix[i + 1] - prefix[i]));
        }
        return ans;
    }
}