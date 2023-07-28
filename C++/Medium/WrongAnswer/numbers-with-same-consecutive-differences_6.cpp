class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        
        vector<int> res;
        int start = 1;
        if (n == 1) {
            res.push_back(0);
            start = 0;
        }
        for (int i = start; i < 10; i++) {
            dfs(i, n, k, res);
        }
        return res;
    }
    void dfs(int cur, int n, int k, vector<int>& res) {
        if (n == 0) {
            res.push_back(cur);
            return;
        }
        int last = cur % 10;
        if (last + k < 10) {
            dfs(cur*10+last+k, n-1, k, res);
        }
        if (k != 0 && last - k >= 0) {
            dfs(cur*10+last-k, n-1, k, res);
        }
    }
};