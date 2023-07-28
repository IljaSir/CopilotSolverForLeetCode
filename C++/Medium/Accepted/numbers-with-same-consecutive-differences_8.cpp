class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        
        vector<int> res;
        for (int i = (n > 1 ? 1 : 0); i <= 9; i++) {
            dfs(n - 1, k, i, res);
        }
        return res;
    }
    void dfs(int n, int k, int num, vector<int>& res) {
        if (n == 0) {
            res.push_back(num);
            return;
        }
        int last = num % 10;
        if (last - k >= 0) dfs(n - 1, k, num * 10 + last - k, res);
        if (last + k <= 9 && k != 0) dfs(n - 1, k, num * 10 + last + k, res);
    }
};