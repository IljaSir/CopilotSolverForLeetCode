class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = count(s);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];(1 + dp[i - zeros][j - ones], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
}