class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        
        vector<int> res;
        if (n == 1) {
            res.push_back(0);
        }
        for (int i = 1; i <= 9; i++) {
            dfs(i, n - 1, k, res);
        }
        return res;
    }
    void dfs(int num, int n, int k, vector<int>& res) {
        if (n == 0) {
            res.push_back(num);
            return;
        }
        int lastDigit = num % 10;
        if (lastDigit - k >= 0) {
            dfs(num * 10 + lastDigit - k, n - 1, k, res);
        }
        if (lastDigit + k <= 9 && k != 0) {
            dfs(num * 10 + lastDigit + k, n - 1, k, res);
        }
    }
};