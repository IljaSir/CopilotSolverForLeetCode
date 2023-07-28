class Solution {
    public String minimizeResult(String expression) {
        
        int n = expression.length();
        int[][] min = new int[n][n];
        int[][] max = new int[n][n];
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                min[i][i] = max[i][i] = expression.charAt(i) - '0';
            }
        }
        for (int i = 3; i <= n; i += 2) {
            for (int j = 0; j <= n - i; ++j) {
                int k = j + i - 1;
                min[j][k] = Integer.MAX_VALUE;
                max[j][k] = Integer.MIN_VALUE;
                for (int l = j + 1; l < k; l += 2) {
                    int a = min[j][l - 1];
                    int b = min[l + 1][k];
                    int c = max[j][l - 1];
                    int d = max[l + 1][k];
                    if (expression.charAt(l) == '+') {
                        min[j][k] = Math.min(min[j][k], a + b);
                        max[j][k] = Math.max(max[j][k], c + d);
                    } else {
                        min[j][k] = Math.min(min[j][k], a * b);
                        max[j][k] = Math.max(max[j][k], c * d);
                    }
                }
            }
        }
        return dfs(expression, 0, n - 1, min, max);
    }
    
    private String dfs(String expression, int i, int j, int[][] min, int[][] max) {
        if (i == j) {
            return expression.substring(i, i + 1);
        }
        if (min[i][j] == max[i][j]) {
            return Integer.toString(min[i][j]);
        }
        for (int l = i + 1; l < j; l += 2) {
            if (min[i][l - 1] + min[l + 1][j] == min[i][j]) {
                return "(" + dfs(expression, i, l - 1, min, max) + expression.charAt(l) + dfs(expression, l + 1, j, min, max) + ")";
            }
            if
    }
}