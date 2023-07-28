class Solution {
public:
    string minimizeResult(string expression) {
        
        int n = expression.length();
        vector<int> nums;
        vector<char> ops;
        string num;
        for (int i = 0; i < n; ++i) {
            if (isdigit(expression[i])) {
                num += expression[i];
            } else {
                nums.push_back(stoi(num));
                num = "";
                ops.push_back(expression[i]);
            }
        }
        nums.push_back(stoi(num));
        int m = nums.size();
        vector<vector<int>> dp(m, vector<int>(m));
        vector<vector<int>> pos(m, vector<int>(m));
        for (int i = 0; i < m; ++i) {
            dp[i][i] = nums[i];
            pos[i][i] = i;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j + i < m; ++j) {
                int k = j + i;
                dp[j][k] = dp[j][k - 1] + dp[k][k];
                pos[j][k] = k;
                for (int l = j + 1; l < k; ++l) {
                    int tmp = dp[j][l - 1] + dp[l][k];
                    if (tmp < dp[j][k]) {
                        dp[j][k] = tmp;
                        pos[j][k] = l;
                    }
                }
            }
        }
        string ans;
        int i = 0, j = m - 1;
        while (i < j) {
            int k = pos[i][j];
            if (k == j) {
                ans += to_string(nums[i]);
                ans += ops[i];
                ++i;
            } else {
                ans += "(";
                while (i < k) {
                    ans += to_string(nums[i]);
                    ans += ops[i];
                    ++i;
                }
                ans += to_string(nums[k]);
                ans += ")";
                i = k + 1;
            }
        }
        ans += to_string(nums[j]);
        return ans;
    }
};