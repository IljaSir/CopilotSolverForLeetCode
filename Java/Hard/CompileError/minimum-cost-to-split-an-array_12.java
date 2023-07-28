class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] next = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < i + 1 - max > j) {
                        break;
                    }
                    dp[r + 1][j - (r - i + 1 - max)] = Math.min(dp[r + 1][j - (r - i + 1 - max)], dp[i][j] + r - i + 1);
                }
            }
        }
        return dp[n][0];
    }
}