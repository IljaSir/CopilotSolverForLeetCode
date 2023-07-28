class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        
        int x = 0, y = 0, d = 0;
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0};
        set<pair<int, int>> obstacleSet;
        for (auto& obstacle: obstacles) {
            obstacleSet.insert(make_pair(obstacle[0], obstacle[1]));
        }
        int ans = 0;
        for (auto& command: commands) {
            if (command == -2) {
                d = (d + 3) % 4;
            } else if (command == -1) {
                d = (d + 1) % 4;
            } else {
                for (int i = 0; i < command; ++i) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (obstacleSet.find(make_pair(nx, ny)) == obstacleSet.end()) {
                        x = nx;
                        y = ny;
                        ans = max(ans, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
};