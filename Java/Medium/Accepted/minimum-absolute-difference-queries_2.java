class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int[][] freq = new int[n][101];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 100; j++) {
                freq[i][j] = i > 0 ? freq[i - 1][j] : 0;
            }
            freq[i][nums[i]]++;
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];
            int prev = -1, min = Integer.MAX_VALUE;
            for (int j = 1; j <= 100; j++) {
                if (freq[r][j] - (l > 0 ? freq[l - 1][j] : 0) > 0) {
                    if (prev != -1) {
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