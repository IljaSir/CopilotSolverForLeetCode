class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        
        if (n == 1) return {0,1,2,3,4,5,6,7,8,9};
        vector<int> res;
        for (int i = 1; i < 10; i++) {
            dfs(res, i, n, k);
        }
        return res;
    }
    void dfs(vector<int> &res, int cur, int n, int k) {
        if (n == 0) {
            res.push_back(cur);
            return;
        }
        int last = cur % 10;
        if (last + k < 10) dfs(res, cur * 10 + last + k, n - 1, k);
        if (k > 0 && last - k >= 0) dfs(res, cur * 10 + last - k, n - 1, k);
    }
};