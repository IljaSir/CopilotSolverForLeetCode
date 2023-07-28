class Solution {
public:
    string minimizeResult(string expression) {
        
        int n = expression.length();
        vector<int> num;
        vector<char> op;
        int i = 0;
        while (i < n) {
            if (expression[i] == '+') {
                op.push_back('+');
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
        int m = num.size();
        vector<vector<int>> dp(m, vector<int>(m, INT_MAX));
        vector<vector<int>> parent(m, vector<int>(m, -1));
        for (int i = 0; i < m; i++) {
            dp[i][i] = num[i];
        }
        for (int l = 2; l <= m; l++) {
            for (int i = 0; i <= m - l; i++) {
                int j = i + l - 1;
                for (int k = i; k < j; k++) {
                    int cur = dp[i][k] + dp[k + 1][j];
                    if (cur < dp[i][j]) {
                        dp[i][j] = cur;
                        parent[i][j] = k;
                    }
                }
            }
        }
        string str = "";
        int i = 0;
        int j = m - 1;
        while (i < j) {
            int k = parent[i][j];
            if (k == i) {
                str += "(";
            } else {
                str += ")";
            }
            str += to_string(num[i]);
            str += op[i];
            i++;
        }
        str += to_string(num[j]);
        if (parent[i][j] == j - 1) {
            str += ")";
        }
        return str;
    }
};