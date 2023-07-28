class Solution {
    public int maximumCount(int[] nums) {
        
        int positive = 0;
        int negative = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negative++;
                positive = 0;
            } else if (nums[i] > 0) {
                positive++;
                negative = 0;
            } else {
                positive = 0;
                negative = 0;
            }
            max = Math.max(max, Math.max(positive, negative));
        }
        return max;
    }
}