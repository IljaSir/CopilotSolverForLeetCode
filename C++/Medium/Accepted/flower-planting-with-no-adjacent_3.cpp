class Solution {
public:
    vector<int> gardenNoAdj(int n, vector<vector<int>>& paths) {
        
        vector<vector<int>> G(n);
        for (auto& p : paths) {
            G[p[0]-1].push_back(p[1]-1);
            G[p[1]-1].push_back(p[0]-1);
        }
        vector<int> ret(n);
        for (int i = 0; i < n; ++i) {
            vector<bool> used(5);
            for (auto& j : G[i]) {
                used[ret[j]] = true;
            }
            for (int j = 1; j <= 4; ++j) {
                if (!used[j]) {
                    ret[i] = j;
                    break;
                }
            }
        }
        return ret;
    }
};