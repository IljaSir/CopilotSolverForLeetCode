class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE 
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], nums[i - 1]);
        }
        for (int i = 2; i <= n; i++) { 1]));
                }
                dp[i][j] = min;
            }
        }
        return dp[n][k];
    }
}