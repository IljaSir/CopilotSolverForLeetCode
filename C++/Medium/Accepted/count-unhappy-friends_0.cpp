class Solution {
public:
    int unhappyFriends(int n, vector<vector<int>>& preferences, vector<vector<int>>& pairs) {
        
        vector<vector<int>> order(n, vector<int>(n));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - 1; ++j) {
                order[i][preferences[i][j]] = j;
            }
        }
        vector<int> match(n);
        for (auto& p : pairs) {
            match[p[0]] = p[1];
            match[p[1]] = p[0];
        }
        int ans = 0;
        for (int x = 0; x < n; ++x) {
            int y = match[x];
            int index = order[x][y];
            for (int i = 0; i < index; ++i) {
                int u = preferences[x][i];
                int v = match[u];
                if (order[u][x] < order[u][v]) {
                    ++ans;
                    break;
                }
            }
        }
        return ans;
    }
};