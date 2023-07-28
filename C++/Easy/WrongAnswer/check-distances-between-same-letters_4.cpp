class Solution {
public:
    bool checkDistances(string s, vector<int>& distance) {
        
        int n = s.size();
        int m = distance.size();
        vector<vector<int>> pos(m);
        for (int i = 0; i < n; i++) {
            pos[s[i] - 'a'].push_back(i);
        }
        for (int i = 0; i < m; i++) {
            if (pos[i].size() != 2) {
                continue;
            }
            int dist = pos[i][1] - pos[i][0];
            if (dist != distance[i]) {
                return false;
            }
        }
        return true;
    }
};