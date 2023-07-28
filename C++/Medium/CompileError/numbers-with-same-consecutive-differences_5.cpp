class Solution {
public:
    vector<int> numsSameConsecDiff(int n, int k) {
        
        vector<int> res;
        if (n == 1) {
            for (int i = 0; i <= 9; ++i) {
                res.push_back(i);
            }
        }
        else {
            for (int i = 1; i <= 9; ++i) {
                dfs(i, n, k, res);
            }
        }
        return res;
    }
};