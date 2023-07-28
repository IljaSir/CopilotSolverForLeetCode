class Solution {
    public int minOperationsToFlip(String expression) {
        
        int n = expression.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return dfs(expression, 0, n - 1, dp);
    }
    
    private int dfs(String expression, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        if (i == j) {
            return expression.charAt(i) == '0' ? 0 : 1;
        }
        int res = Integer.MAX_VALUE;
        if (expression.charAt(i) == '(' && expression.charAt(j) == ')') {
            res = Math.min(res, dfs(expression, i + 1, j - 1, dp));
        }
        int left = i, right = j;
        while (left < right) {
            if (expression.charAt(left) == '(') {
                int count = 1;
                while (left < right && count != 0) {
                    left++;
                    if (expression.charAt(left) == '(') {
                        count++;
                    } else if (expression.charAt(left) == ')') {
                        count--;
                    }
                }
            }
            if (expression.charAt(right) == ')') {
                int count = 1;
                while (left < right && count != 0) {
                    right--;
                    if (expression.charAt(right) == '(') {
                        count--;
                    } else if (expression.charAt(right) == ')') {
                        count++;
                    }
                }
            }
            if (expression.charAt(left) == '&' && expression.charAt(right) == '&') {
                res = Math.min(res, dfs(expression, i, left - 1, dp) + dfs(expression, left + 1, right - 1, dp) + dfs(expression, right + 1, j, dp));
            } else if (expression.charAt(left) == '|' && expression.charAt(right) == '|') {
                res = Math.min(res, dfs(expression, i, left - 1, dp) + dfs(expression, left + 1, right - 1, dp) + dfs(expression, right + 1, j, dp));
            } else if (expression.charAt(left) == '&' && expression.charAt(right) ==
    }
}