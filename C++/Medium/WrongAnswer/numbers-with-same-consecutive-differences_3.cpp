class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        
        vector<int> ans;
        for (int i = 1; i <= 9; ++i) {
            dfs(i, n, k, ans);
        }
        if (n == 1) ans.push_back(0);
        return ans;
    }
    void dfs(int num, int n, int k, vector<int>& ans) {
        if (n == 0) {
            ans.push_back(num);
            return;
        }
        int last = num % 10;
        if (last + k <= 9) dfs(num * 10 + last + k, n - 1, k, ans);
        if (k != 0 && last - k >= 0) dfs(num * 10 + last - k, n - 1, k, ans);
    }
};