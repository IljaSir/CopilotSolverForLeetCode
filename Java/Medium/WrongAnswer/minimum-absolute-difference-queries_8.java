class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[][][] pre = new int[nums.length][101][2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 101; j++) {
                if (i > 0) {
                    pre[i][j][0] = pre[i - 1][j][0];
                }
                if (nums[i] == j) {
                    pre[i][j][0] = i;
                }
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < 101; j++) {
                if (i < nums.length - 1) {
                    pre[i][j][1] = pre[i + 1][j][1];
                }
                if (nums[i] == j) {
                    pre[i][j][1] = i;
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int min = Integer.MAX_VALUE;
            int preMin = -1;
            for (int j = 0; j < 101; j++) {
                int left = pre[l][j][0];
                int right = pre[r][j][1];
                if (left <= r && right >= l) {
                    if (preMin != -1) {
                        min = Math.min(min, j - preMin);
                    }
                    preMin = j;
                }
            }
            if (min == Integer.MAX_VALUE) {
                ans[i] = -1;
            } else {
                ans[i] = min;
            }
        }
        return ans;
    }
}