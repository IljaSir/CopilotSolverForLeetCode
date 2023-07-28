class Solution {
public:
    vector<int> diffWaysToCompute(string expression) {
        
        int n = expression.size();
        vector<int> nums;
        vector<char> ops;
        string num;
        for (int i = 0; i < n; i++) {
            if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*') {
                nums.push_back(stoi(num));
                ops.push_back(expression[i]);
                num = "";
            } else {
                num += expression[i];
            }
        }
        nums.push_back(stoi(num));
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(n, vector<int>()));
        for (int i = 0; i < n; i += 2) {
            dp[i][i].push_back(nums[i / 2]);
        }
        for (int l = 2; l <= n; l += 2) {
            for (int i = 0; i + l - 1 < n; i += 2) {
                int j = i + l - 1;
                for (int k = i; k < j; k += 2) {
                    for (int a : dp[i][k]) {
                        for (int b : dp[k + 2][j]) {
                            if (ops[k / 2] == '+') {
                                dp[i][j].push_back(a + b);
                            } else if (ops[k / 2] == '-') {
                                dp[i][j].push_back(a - b);
                            } else {
                                dp[i][j].push_back(a * b);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
};