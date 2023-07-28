class Solution {
public:
    int unhappyFriends(int n, vector<vector<int>>& preferences, vector<vector<int>>& pairs) {
        
        int cnt = 0;
        vector<int> pair(n, 0);
        for (auto& p : pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }
        for (int x = 0; x < n; ++x) {
            int y = pair[x];
            int idx = 0;
            while (preferences[x][idx] != y) {
                int u = preferences[x][idx];
                int v = pair[u];
                for (int i = 0; i < preferences[u].size(); ++i) {
                    if (preferences[u][i] == x) {
                        break;
                    }
                    if (preferences[u][i] == v) {
                        cnt++;
                        break;
                    }
                }
                idx++;
            }
        }
        return cnt;
    }
};