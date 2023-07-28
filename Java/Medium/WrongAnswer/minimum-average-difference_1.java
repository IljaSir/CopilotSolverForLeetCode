class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = prefix[i];
            int right = prefix[n - 1] - prefix[i];
            int avg = (left + right) / (n - i);
            int diff = Math.abs(avg - (left / (i + 1)));
            if (diff < min) {
                min = diff;
                res = i;
            }
        }
        return res;
    }
}