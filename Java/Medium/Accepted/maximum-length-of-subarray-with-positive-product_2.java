class Solution {
    public int getMaxLen(int[] nums) {
        
        int n = nums.length;
        int[] positive = new int[n];
        int[] negative = new int[n];
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int result = positive[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                if (negative[i - 1] > 0) {
                    negative[i] = negative[i - 1] + 1;
                }
            } else if (nums[i] < 0) {
                negative[i] = positive[i - 1] + 1;
                if (negative[i - 1] > 0) {
                    positive[i] = negative[i - 1] + 1;
                }
            }
            result = Math.max(result, positive[i]);
        }
        return result;
    }
}