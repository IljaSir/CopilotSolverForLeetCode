class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < n - 1; i++) {
            int left = (prefix[i] + i) / (i + 1);
            int right = (prefix[n - 1] - prefix[i]) / (n - i - 1);
            int diff = Math.abs(left - right);
            if (diff < min) {
                min = diff;
                minIdx = i;
            }
        }
        return minIdx;
    }
}