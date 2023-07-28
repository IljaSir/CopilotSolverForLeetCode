class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        int max = 0;
        int start = 0;
        int end = 0;
        int[] set = new int[10001];
        while (end < nums.length) {
            if (set[nums[end]] == 0) {
                set[nums[end]]++;
                end++;
            } else {
                set[nums[start]]--;
                start++;
            }
            if (start == end) {
                max = Math.max(max, sum[end - 1]);
            } else {
                max = Math.max(max, sum[end - 1] - sum[start - 1]);
            }
        }
        return max;
    }
}