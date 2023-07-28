class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[][] pre = new int[nums.length][101];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= 100; j++) {
                pre[i][j] = i == 0 ? 0 : pre[i - 1][j];
                if (nums[i] == j) {
                    pre[i][j]++;
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int preL = q[0] == 0 ? 0 : q[0] - 1;
            int preR = q[1];
            int preVal = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= 100; j++) {
                int val = pre[preR][j] - pre[preL][j];
                if (val > 0) {
                    if (preVal > 0) {
                        min = Math.min(min, j - preVal);
                    }
                    preVal = j;
                }
            }
            ans[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return ans;
    }
}