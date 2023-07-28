class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        
        int x = 0, y = 0, dir = 0;
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0};
        unordered_set<string> obs;
        for (auto &obstacle : obstacles) {
            obs.insert(to_string(obstacle[0]) + " " + to_string(obstacle[1]));
        }
        int ans = 0;
        for (auto &command : commands) {
            if (command == -2) {
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                dir = (dir + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (obs.find(to_string(nx) + " " + to_string(ny)) == obs.end()) {
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