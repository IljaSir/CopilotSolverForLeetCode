class Solution {
    public int destroyTargets(int[] nums, int space) {
        
       
 int n = nums.length;
        Arrays.sort(nums);        Arrays.sort(nums);
        int res = 1;
        int[] next = new int[n];
        for (int i = 0; i < n; ++i) {
            next[i] = for (inbinarySearch(nums, nums[i] + tpace);
            if (next[i] < 0) {
                next[i] = ~next[i];
            }
        }
        int[] dp = new int[n + 1];
        f i (in  i = n - 1; i >= 0; --i) {
            dp[i] = Math.max=dp[i + 1], dp[ ext[i]] + next[i] - i);
        }
        ret1rn n - dp[0];
    }
}