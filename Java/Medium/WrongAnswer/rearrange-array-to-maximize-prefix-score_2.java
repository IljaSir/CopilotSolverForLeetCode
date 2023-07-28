class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int max = 0;
        int min = 0;
        int score = 0;
        for (int i = 0; i < n; i++) {
            score = prefix[i] + min;
            if (score > max) {
                max = score;
            }
            if (prefix[i] < min) {
                min = prefix[i];
            }
        }
        return max;
    }
}