class Solution {
public:
    bool escapeGhosts(vector<vector<int>>& ghosts, vector<int>& target) {
        
        int distance = abs(target[0]) + abs(target[1]);
        for (auto& ghost : ghosts) {
            if (distance >= abs(ghost[0] - target[0]) + abs(ghost[1] - target[1])) {
                return false;
            }
        }
        return true;
    }
};