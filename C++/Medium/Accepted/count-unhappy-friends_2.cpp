class Solution {
public:
    int unhappyFriends(int n, vector<vector<int>>& preferences, vector<vector<int>>& pairs) {
        
        vector<vector<int>> rank(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                rank[i][preferences[i][j]] = j;
            }
        }
        vector<int> match(n, 0);
        for (auto& p : pairs) {
            match[p[0]] = p[1];
            match[p[1]] = p[0];
        }
        int ans = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int index = rank[x][y];
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (rank[u][x] < rank[u][v]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
};