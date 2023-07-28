class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i += 2) {
            dp[i][i] = s.charAt(i) - '0';
        }
        for (int i = 2; i < n; i += 2) {
            for (int j = 0; j < n - i; j += 2) {
                int k = j + i;
                dp[j][k] = Integer.MAX_VALUE;
                for (int m = j + 1; m < k; m += 2) {
                    int a = dp[j][m - 1];
                    int b = dp[m + 1][k];
                    int c = 0;
                    if (s.charAt(m) == '*') {
                        c = a * b;
                    } else {
                        c = a + b;
                    }
                    dp[j][k] = Math.min(dp[j][k], c);
                }
            }
        }
        int correct = dp[0][n - 1];
        int score = 0;
        for (int answer : answers) {
            if (answer == correct) {
                score += 5;
                continue;
            }
            if (answer > 1000) {
                continue;
            }
            boolean found = false;
            for (int i = 0; i < n; i += 2) {
                int a = s.charAt(i) - '0';
                for (int j = i + 2; j < n; j += 2) {
                    int b = s.charAt(j) - '0';
                    if (s.charAt(j - 1) == '*') {
                        if (answer == a * b + dp[j + 1][n - 1] || answer == a * b + dp[0][i - 1]) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found) {
                    break;
                }
            }
            if (found) {
                score += 2;
            }
        }
        return score;
    }
}