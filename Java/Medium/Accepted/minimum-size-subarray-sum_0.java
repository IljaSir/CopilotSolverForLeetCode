class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int res = n + 1;
        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(sums, i + 1, n + 1, sums[i] + target);
            if (j < 0) {
                j = -j - 1;
            }
            if (j <= n) {
                res = Math.min(res, j - i);
            }
        }
        return res == n + 1 ? 0 : res;
    }
}