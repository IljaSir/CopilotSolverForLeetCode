class Solution {
public:
    int scoreOfStudents(string s, vector<int>& answers) {
        
        int n = s.length();
        int n2 = n / 2;
        vector<vector<int>> dp(n2 + 1, vector<int>(n2 + 1, 0));
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n2 - i; j++) {
                int k = 2 * j + i;
                if (i == 0) {
                    dp[j][j] = s[k] - '0';
                } else {
                    for (int m = 0; m < i; m++) {
                        int p = j + m;
                        int q = p + 1;
                        int r = q + i - m;
                        if (s[2 * q - 1] == '+') {
                            dp[j][r] = max(dp[j][r], dp[j][p] + dp[q][r]);
                        } else {
                            dp[j][r] = max(dp[j][r], dp[j][p] * dp[q][r]);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int x : answers) {
            if (x == dp[0][n2]) {
                ans += 5;
            } else if (x > dp[0][n2] && x <= 1000) {
                bool valid = false;
                for (int i = 0; i < n2; i++) {
                    for (int j = 0; j < n2 - i; j++) {
                        int k = 2 * j + i;
                        if (i == 0) {
                            if (x == s[k] - '0') {
                                valid = true;
                                break;
                            }
                        } else {
                            for (int m = 0; m < i; m++) {
                                int p = j + m;
                                int q = p + 1;
                                int r = q + i - m;
                                if (s[2 * q - 1] == '+') {
                                    if (x == dp[j][p] + dp[q][r]) {
                                        valid = true;
                                        break;
                                    }
                                } else {
                                    if (x == dp[j][p] * dp[q][r]) {
                                        valid = true;
                                        break;
                                    }
    }
};