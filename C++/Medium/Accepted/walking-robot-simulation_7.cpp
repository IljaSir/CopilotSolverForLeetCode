class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        
        int x = 0, y = 0, d = 0;
        int maxDist = 0;
        set<pair<int, int>> obs;
        for (auto& o : obstacles) {
            obs.insert({o[0], o[1]});
        }
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (auto& cmd : commands) {
            if (cmd == -1) {
                d = (d + 1) % 4;
            } else if (cmd == -2) {
                d = (d + 3) % 4;
            } else {
                for (int i = 0; i < cmd; ++i) {
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];
                    if (obs.find({nx, ny}) == obs.end()) {
                        x = nx;
                        y = ny;
                        maxDist = max(maxDist, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return maxDist;
    }
};