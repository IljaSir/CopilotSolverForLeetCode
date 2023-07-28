class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][2];
        int[] res = new int[queries.length];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], Math.max(dp[i][j - 1][0], dp[i][j - 1][1])));
                if (grid[i - 1][j - 1] > dp[i][j][0]) {
                    dp[i][j][1] = dp[i][j][0] + 1;
                    dp[i][j][0] = grid[i - 1][j - 1];
                } else {
                    dp[i][j][1] = grid[i - 1][j - 1];
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = 0;
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    if (grid[j - 1][k - 1] > queries[i]) {
                        res[i] = Math.max(res[i], dp[j][k][0]);
                    } else {
                        res[i] = Math.max(res[i], dp[j][k][1]);
                    }
                }
            }
        }
        return res;
                            hi = mid - 1;
                        }
                    }
                    max = Math.max(max, prefix[maxj][maxk] - prefix[maxj][k - 1] - prefix[j - 1][maxk] + prefix[j - 1][k - 1]);
                }
            }
            res[i] = max;
        }
        return res;
    }
}