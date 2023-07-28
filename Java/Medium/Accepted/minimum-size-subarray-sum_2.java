class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int s = target + sum[i - 1];
            int bound = Arrays.binarySearch(sum, s);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                res = Math.min(res, bound - (i - 1));
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}