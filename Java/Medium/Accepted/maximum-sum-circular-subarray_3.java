class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int currMax = 0;
        int currMin = 0;
        for (int num : nums) {
            currMax = Math.max(currMax + num, num);
            max = Math.max(max, currMax);
            currMin = Math.min(currMin + num, num);
            min = Math.min(min, currMin);
            sum += num;
        }
        return max > 0 ? Math.max(max, sum - min) : max;
    }
}