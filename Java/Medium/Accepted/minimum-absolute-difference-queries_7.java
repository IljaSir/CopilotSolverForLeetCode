class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        int[][] last = new int[n][101];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 100; j++) {
                last[i][j] = i > 0 ? last[i - 1][j] : -1;
            }
            last[i][nums[i]] = i;
        }
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];
            int prev = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= 100; j++) {
                if (last[r][j] >= l) {
                    if (prev >= 0) {
                        min = Math.min(min, j - prev);
                    }
                    prev = j;
                }
            }
            ans[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return ans;
    }
}