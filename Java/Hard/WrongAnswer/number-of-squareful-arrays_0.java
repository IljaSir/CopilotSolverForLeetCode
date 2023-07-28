class Solution {
    public int numSquarefulPerms(int[] nums) {
        
        int n = nums.length;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int r = (int) Math.sqrt(nums[i] + nums[j]);
                g[i][j] = g[j][i] = r * r == nums[i] + nums[j] ? 1 : 0;
            }
        }
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int i = 0; i < 1 << n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    cnt++;
                }
            }
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 0 && (cnt == 0 || g[j][Integer.numberOfTrailingZeros(i)] == 1)) {
                    f[i | 1 << j] += f[i];
                }
            }
        }
        return f[(1 << n) - 1];
    }
}