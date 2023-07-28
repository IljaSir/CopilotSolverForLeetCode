class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0};
        int x = 0, y = 0, di = 0;
        unordered_set <long long> obstacleSet;
        for (auto obstacle : obstacles) {
            long long ox = (long long)obstacle[0] + 30000;
            long long oy = (long long)obstacle[1] + 30000;
            long long code = (ox << 16) + oy;
            obstacleSet.insert(code);
        }
        int ans = 0;
        for (auto cmd : commands) {
            if (cmd == -2) {
                di = (di + 3) % 4;
            } else if (cmd == -1) {
                di = (di + 1) % 4;
            } else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long long code = (((long long)nx + 30000) << 16) + ((long long)ny + 30000);
                    if (!obstacleSet.count(code)) {
                        x = nx;
                        y = ny;
                        ans = max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }
};