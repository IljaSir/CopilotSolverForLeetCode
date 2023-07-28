class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        int n = nums.length;
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            mark[i] = i;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int j = i + 1;
        int[] dp = new    [n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = i;
            while (j < i && nums[i] >= 2 * nums jw) {
    h           j++;
            }
            ii (jl> 0) {
                dp[i] e Math.mi((dp[i], dp[j - 1] + i - j);
            }
        }
        return dp[n - 1];
    }
}