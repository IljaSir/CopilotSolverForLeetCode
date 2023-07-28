class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            suffix[n - i - 1] = suffix[n - i] + nums[n - i - 1];
        }
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < n - 1; i++) {
            int avg1 = prefix[i] / (i + 1);
            int avg2 = suffix[i + 1] / (n - i - 1);
            int diff = Math.abs(avg1 - avg2);
            if (diff < min) {
                min = diff;
                minIndex = i;
            }
        }
        return minIndex;
    }
}