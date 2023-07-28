class Solution {
public:
    int minOperationsToFlip(string expression) {
        
        int n = expression.size();
        vector<int> dp(n, n);
        for (int i = 0; i < n; ++i) {
            if (expression[i] == '0') {
                dp[i] = 1;
            } else if (expression[i] == '1') {
                dp[i] = 0;
            }
        }
        for (int i = 1; i < n; ++i) {
            vector<int> ndp(n, n);
            for (int j = 0; j < n - i; ++j) {
                int k = j + i;
                if (expression[k] == '&') {
                    ndp[j] = min(ndp[j], dp[j] + dp[k + 1]);
                    for (int x = j; x < k; ++x) {
                        if (expression[x] == '|') {
                            ndp[j] = min(ndp[j], dp[j] + dp[x + 1] + 1);
                        }
                    }
                } else if (expression[k] == '|') {
                    ndp[j] = min(ndp[j], dp[j] + dp[k + 1]);
                    for (int x = j; x < k; ++x) {
                        if (expression[x] == '&') {
                            ndp[j] = min(ndp[j], dp[j] + dp[x + 1] + 1);
                        }
                    }
                } else {
                    ndp[j] = min(ndp[j], dp[j] + dp[k + 1] + 1);
                    for (int x = j; x < k; ++x) {
                        if (expression[x] == '&') {
                            ndp[j] = min(ndp[j], dp[j] + dp[x + 1]);
                        } else if (expression[x] == '|') {
                            ndp[j] = min(ndp[j], dp[j] + dp[x + 1]);
                        }
                    }
                }
            }
            dp = move(ndp);
        }
        return dp[0];
    }
};