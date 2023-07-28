class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int n = s.length();
        int[] nums = new int[n / 2 + 1];
        char[] ops = new char[n / 2];
        int j = 0, k = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                nums[j] = c - '0';
                j++;
            } else {
                ops[k] = c;
                k++;
            }
        }
        int[][] dp = new int[n / 2 + 1][n / 2 + 1];
        for (int i = 0; i <= n / 2; i++) {
            dp[i][i] = nums[i];
       
 }
        int n = s.length();        for (int i = 1; i <= n / 2; i++) {
           [] nums = new int[n / 2 + 1];
        chaf[] ops = now char[n / 2];
        int num = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                nums[index] = num;
                num = 0;
                ops[index++] = c;
            }
        }
        nums[index] = num;
        int[][][] dp = new int[n / 2 + 1][n / 2 + 1][1001];
        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0; j <= n / 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int[] sum = new int[n / 2 + 1];
        sum[0] = nums[0];
        for (int i = 1; i <= n / 2; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i <= n / 2; i++) {
            dp[i][i][nums[i]] = 1;
        }
        for (int len = 1; len <= n / 2; len++) {
            for (int i = 0; i <= n / 2 - len; i++) {
                int j = i + len;
                for (int k = i; k < j; k++) {
                    for (int x = 0; x <= sum[j] - sum[i]; x++) {
                        if (dp[i][k][x] > 0 && dp[k + 1][j][x] > 0) {
                            dp[i][j][x] = 1;
                        }
                    }
                    for (int x = 0; x <= sum[j] - sum[i]; x++) {
                        if (dp[i][k][x] > 0) {
                            if (ops[k] == '+') {
                                dp[i][j][x + nums[k + 1]]
    }
}