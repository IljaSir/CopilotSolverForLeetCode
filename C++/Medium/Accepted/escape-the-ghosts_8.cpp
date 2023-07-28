class Solution {
public:
    bool escapeGhosts(vector<vector<int>>& ghosts, vector<int>& target) {
        
        int n = ghosts.size();
        int x = target[0];
        int y = target[1];
        int dist = abs(x) + abs(y);
        for (int i = 0; i < n; ++i) {
            int x1 = ghosts[i][0];
            int y1 = ghosts[i][1];
            if (abs(x-x1) + abs(y-y1) <= dist) {
                return false;
            }
        }
        return true;
    }
};