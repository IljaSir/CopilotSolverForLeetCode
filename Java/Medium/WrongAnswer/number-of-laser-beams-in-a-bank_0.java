class Solution {
    public int numberOfBeams(String[] bank) {
        
        int m = bank.length;
        int n = bank[0].length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bank[i].charAt(j) == '1') {
                    dp[i][j] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 1) {
                    for (int k = i + 1; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            if (dp[k][l] == 1) {
                                boolean flag = true;
                                for (int t = i + 1; t < k; t++) {
                                    if (dp[t][j] == 1) {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (flag) {
                                    res++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}