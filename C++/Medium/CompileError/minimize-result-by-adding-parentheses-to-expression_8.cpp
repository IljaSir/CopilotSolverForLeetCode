class Solution {
public:
    string minimizeResult(string expression) {
        
        int n = expression.size();
        vector<int> nums;
        vector<char> ops;
        int i = 0;
        while (i < n) {
            char ch = expression[i];
            if (ch == '+') {
                ops.push_back(ch);
                i++;
            } else {
                int j = i + 1;
                while (j < n && isdigit(expression[j])) {
                    j++;
                }
                nums.push_back(stoi(expression.substr(i, j - i)));
                i = j;
            }
        }
        int m = nums.size();
        vector<vector<int>> dp(m, vector<int>(m, INT_MAX));
        vector<vector<int>> dp2(m, vector<int>(m, INT_MAX));
        for (int i = 0; i < m; i++) {
            dp[i][i] = nums[i];
            dp2[i][i] = nums[i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < m - i; j++) {
                for (int k = j; k < j + i; k++) {
                    if (ops[k] == '+') {
                        if (dp[j][k] != INT_MAX && dp[k + 1][j + i] != INT_MAX) {
                            dp[j][j + i] = min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i]);
                        }
                        if (dp2[j][k] != INT_MAX && dp2[k + 1][j + i] != INT_MAX) {
                            dp2[j][j + i] = min(dp2[j][j + i], dp2[j][k] + dp2[k + 1][j + i]);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < m - i; j++) {
                for (int k = j; k < j + i; k++) {
                    if (ops[k] == '+') {
                        if (dp[j][k] != INT_MAX && dp2[k + 1][j + i] != INT_MAX) {
                            dp[j][j + i] = min(dp[j][j + i], dp[j][
    }
};