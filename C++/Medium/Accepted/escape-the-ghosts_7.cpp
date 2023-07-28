class Solution {
public:
    bool escapeGhosts(vector<vector<int>>& ghosts, vector<int>& target) {
        
        int x = target[0], y = target[1];
        int d = abs(x) + abs(y);
        for (auto& g : ghosts) {
            if (abs(x - g[0]) + abs(y - g[1]) <= d) {
                return false;
            }
        }
        return true;
    }
};