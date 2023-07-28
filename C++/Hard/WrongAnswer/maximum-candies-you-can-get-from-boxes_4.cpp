class Solution {
public:
    int maxCandies(vector<int>& status, vector<int>& candies, vector<vector<int>>& keys, vector<vector<int>>& containedBoxes, vector<int>& initialBoxes) {
        
        int n = status.size();
        vector<bool> visited(n, false);
        vector<bool> opened(n, false);
        vector<bool> hasKey(n, false);
        for (int i = 0; i < initialBoxes.size(); i++) {
            opened[initialBoxes[i]] = true;
        }
        int ans = 0;
        while (true) {
            bool changed = false;
            for (int i = 0; i < n; i++) {
                if (opened[i] && !visited[i]) {
                    visited[i] = true;
                    ans += candies[i];
                    for (int j = 0; j < keys[i].size(); j++) {
                        hasKey[keys[i][j]] = true;
                    }
                    for (int j = 0; j < containedBoxes[i].size(); j++) {
                        opened[containedBoxes[i][j]] = true;
                    }
                    changed = true;
                }
            }
            if (!changed) break;
            for (int i = 0; i < n; i++) {
                if (hasKey[i] && !opened[i] && status[i] == 1) {
                    opened[i] = true;
                    changed = true;
                }
            }
            if (!changed) break;
        }
        return ans;
    }
};