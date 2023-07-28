class Solution {
public:
    string minimizeResult(string expression) {
        
        int n = expression.size();
        vector<int> num;
        vector<char> op;
        int i = 0;
        while (i < n) {
            if (expression[i] == '+') {
                op.push_back(expression[i]);
                i++;
            } else {
                int j = i;
                while (j < n && expression[j] != '+') {
                    j++;
                }
                num.push_back(stoi(expression.substr(i, j - i)));
                i = j;
            }
        }
        vector<vector<int>> dp(n, vector<int>(n, INT_MAX));
        for (int i = 0; i < n; i += 2) {
            dp[i][i] = expression[i] - '0';
        }
        for (int len = 3; len <= n; len += 2) {
            for (int i = 0; i + len <= n; i += 2) {
                int j = i + len - 1;
                for (int k = i; k < j; k += 2) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 2][j]);
                }
                if (op[(i + 1) / 2] == '+') {
                    dp[i][j] = min(dp[i][j], dp[i + 2][j] + num[i / 2]);
                } else {
                    dp[i][j] = min(dp[i][j], dp[i + 2][j] * num[i / 2]);
                }
            }
        }
        vector<vector<string>> ans(n, vector<string>(n));
        for (int i = 0; i < n; i += 2) {
            ans[i][i] = expression.substr(i, 1);
        }
        for (int len = 3; len <= n; len += 2) {
            for (int i = 0; i + len <= n; i += 2) {
                int j = i + len - 1;
                for (int k = i; k < j; k += 2) {
                    if (dp[i][j] == dp[i][k] + dp[k + 2][j]) {
                        ans[i][j] = ans[i][k] + ans[k + 2][
    }
};