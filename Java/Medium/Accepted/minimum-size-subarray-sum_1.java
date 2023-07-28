class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int ans = n + 1;
        for (int i = 1; i <= n; i++) {
            int toFind = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, toFind);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == n + 1 ? 0 : ans;
    }
}