class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        
        set<pair<int, int>> obstacleSet;
        for (auto& obstacle: obstacles) {
            obstacleSet.insert(make_pair(obstacle[0], obstacle[1]));
        }
        int x = 0;
        int y = 0;
        int direction = 0; // 0: north, 1: east, 2: south, 3: west
        int maxDistance = 0;
        for (auto command: commands) {
            if (command == -2) {
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nextX = x;
                    int nextY = y;
                    if (direction == 0) {
                        nextY++;
                    } else if (direction == 1) {
                        nextX++;
                    } else if (direction == 2) {
                        nextY--;
                    } else {
                        nextX--;
                    }
                    if (obstacleSet.find(make_pair(nextX, nextY)) != obstacleSet.end()) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                    maxDistance = max(maxDistance, x * x + y * y);
                }
            }
        }
        return maxDistance;
    }
};