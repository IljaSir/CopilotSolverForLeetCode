class Solution {
public:
    string minimizeResult(string expression) {
        
        int n = expression.size();
        vector<int> nums(n / 2 + 1);
        vector<char> ops(n / 2);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i / 2] = expression[i] - '0';
            }
            else {
                ops[i / 2] = expression[i];
            }
        }
        vector<vector<int>> dp(n / 2 + 1, vector<int>(n / 2 + 1, INT_MAX));
        vector<vector<int>> dp2(n / 2 + 1, vector<int>(n / 2 + 1, INT_MAX));
        for (int i = 0; i <= n / 2; i++) dp[i][i] = nums[i];
        for (int i = 0; i <= n / 2; i++) dp2[i][i] = nums[i];
        for (int len = 1; len <= n / 2; len++) {
            for (int i = 0; i + len <= n / 2; i++) {
                int j = i + len;
                for (int k = i; k < j; k++) {
                    int a = dp[i][k];
                    int b = dp[k + 1][j];
                    int c = dp2[i][k];
                    int d = dp2[k + 1][j];
                    if (ops[k] == '+') {
                        dp[i][j] = min(dp[i][j], a + b);
                        dp2[i][j] = min(dp2[i][j], c + d);
                    }
                    else if (ops[k] == '-') {
                        dp[i][j] = min(dp[i][j], a - b);
                        dp2[i][j] = min(dp2[i][j], c - d);
                    }
                    else {
                        dp[i][j] = min(dp[i][j], a * b);
                        dp2[i][j] = min(dp2[i][j], min(c * d, min(c * b, a * d)));
                    }
                }
            }
        }
        vector<vector<string>> dp3(n / 2 + 1, vector<string>(n / 2 + 1, ""));
        for (int i =
    }
};