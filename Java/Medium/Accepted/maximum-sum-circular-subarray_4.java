class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, curMax = 0, curMin = 0, total = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + num, num);
            min = Math.min(min, curMin);
            total += num;
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }
}