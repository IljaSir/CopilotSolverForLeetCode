class Solution {
public:
    string multiply(string num1, string num2) {
        
        int n = num1.size(), m = num2.size();
        vector<int> ans(n + m, 0);
        for (int i = n - 1; i >= 0; i--) {
            int x = num1[i] - '0';
            for (int j = m - 1; j >= 0; j--) {
                int y = num2[j] - '0';
                ans[i + j + 1] += x * y;
            }
        }
        for (int i = n + m - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }
        int i = 0;
        while (i < n + m - 1 && ans[i] == 0) {
            i++;
        }
        string res;
        for (; i < n + m; i++) {
            res.push_back(ans[i] + '0');
        }
        return res;
    }
};