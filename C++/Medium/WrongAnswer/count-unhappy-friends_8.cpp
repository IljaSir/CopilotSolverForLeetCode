class Solution {
public:
    int unhappyFriends(int n, vector<vector<int>>& preferences, vector<vector<int>>& pairs) {
        
        vector<int> pair(n, -1);
        for (auto &p : pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = pair[i];
            int y = pair[x];
            for (int j : preferences[i]) {
                if (j == x) break;
                if (j == y) {
                    cnt++;
                    break;
                }
                int u = pair[j];
                for (int k : preferences[j]) {
                    if (k == u) break;
                    if (k == i) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt;
    }
};