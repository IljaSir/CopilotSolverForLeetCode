class Solution {
public:
    int unhappyFriends(int n, vector<vector<int>>& preferences, vector<vector<int>>& pairs) {
        
        vector<vector<int>> pref(n, vector<int>(n, 0));
        vector<int> pair(n, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - 1; ++j) {
                pref[i][preferences[i][j]] = j;
            }
        }
        for (auto& p : pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }
        int ans = 0;
        for (int x = 0; x < n; ++x) {
            int y = pair[x];
            int index = pref[x][y];
            for (int i = 0; i < index; ++i) {
                int u = preferences[x][i];
                int v = pair[u];
                if (pref[u][x] < pref[u][v]) {
                    ++ans;
                    break;
                }
            }
        }
        return ans;
    }
};