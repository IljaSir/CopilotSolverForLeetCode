class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        
        int x = 0, y = 0;
        int direction = 0;
        int max_distance = 0;
        set<pair<int, int>> obstacle_set;
        for (auto obstacle : obstacles) {
            obstacle_set.insert(make_pair(obstacle[0], obstacle[1]));
        }
        for (auto command : commands) {
            if (command == -2) {
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int i = 0; i < command; ++i) {
                    int next_x = x + (direction == 1 ? 1 : direction == 3 ? -1 : 0);
                    int next_y = y + (direction == 0 ? 1 : direction == 2 ? -1 : 0);
                    if (obstacle_set.find(make_pair(next_x, next_y)) == obstacle_set.end()) {
                        x = next_x;
                        y = next_y;
                        max_distance = max(max_distance, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return max_distance;
    }
};