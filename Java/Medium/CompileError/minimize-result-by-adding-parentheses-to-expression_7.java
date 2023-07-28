class Solution {
    public String minimizeResult(String expression) {
        
        String[] vals = expression.split("\\+");
        int[] nums = new int[vals.length];
        for (int i = 0; i < vals.length; i++) {
            nums[i] = Integer.parseInt(vals[i]);
        }
        int[][][] dp = new int[vals.length][vals.length][2];
        for (int i = 0; i < vals.length; i++) {
            dp[i][i][0] = nums[i];
            dp[i][i][1] = 0;
        }
        for (int len = 2; len <= vals.length; len++) {
            for (int i = 0; i <= vals.length - len; i++) {
                int j = i + len - 1;
                dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int a = dp[i][k][0] + dp[k + 1][j][0];
                    int b = dp[i][k][0] + dp[k + 1][j][1];
                    int c = dp[i][k][1] + dp[k + 1][j][0];
                    int d = dp[i][k][1] + dp[k + 1][j][1];
                    if (a < dp[i][j][0]) {
                        dp[i][j][0] = a;
                        dp[i][j][1] = 0;
                    }
                    if (b < dp[i][j][0]) {
                        dp[i][j][0] = b;
                        dp[i][j][1] = 1;
                    }
                    if (c < dp[i][j][0]) {
                        dp[i][j][0] = c;
                        dp[i][j][1] = 0;
                    }
                    if (d < dp[i][j][0]) {
                        dp[i][j][0] = d;
                        dp[i][j][1] = 1;
                    }
                }
            }
        }
        String result = "";
        int i = 0;
        int j = vals.length - 1;
        while (i < j) {
            if (dp[i][j][1] == 0) {
                result += "(";
                while (i < j
    }
}