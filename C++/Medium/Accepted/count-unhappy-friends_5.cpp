class Solution {
public:
    int unhappyFriends(int n, vector<vector<int>>& preferences, vector<vector<int>>& pairs) {
        
        vector<vector<int>> p(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                p[i][preferences[i][j]] = j;
            }
        }
        vector<int> match(n, 0);
        for (auto& pair: pairs) {
            match[pair[0]] = pair[1];
            match[pair[1]] = pair[0];
        }
        int ans = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int index = p[x][y];
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (p[u][x] < p[u][v]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
};