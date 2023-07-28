class Solution {
public:
    int unhappyFriends(int n, vector<vector<int>>& preferences, vector<vector<int>>& pairs) {
        
        vector<int> p(n);
        for (auto& pr : pairs) {
            p[pr[0]] = pr[1];
            p[pr[1]] = pr[0];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < preferences[i].size(); ++j) {
                int u = preferences[i][j];
                if (u == p[i]) break;
                int v = p[u];
                int k = 0;
                for (; k < preferences[u].size(); ++k) {
                    if (preferences[u][k] == i) break;
                    if (preferences[u][k] == v) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }
};