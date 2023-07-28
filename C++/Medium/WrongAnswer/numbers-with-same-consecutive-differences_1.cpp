class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        
        if (n == 1) return {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        vector<int> ans;
        for (int i = 1; i < 10; i++) {
            dfs(i, n, k, ans);
        }
        return ans;
    }
    void dfs(int num, int n, int k, vector<int>& ans) {
        if (n == 0) {
            ans.push_back(num);
            return;
        }
        int last = num % 10;
        if (last + k < 10) dfs(num * 10 + last + k, n - 1, k, ans);
        if (last - k >= 0 && k) dfs(num * 10 + last - k, n - 1, k, ans);
    }
};