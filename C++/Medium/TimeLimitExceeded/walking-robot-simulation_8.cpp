class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        
        // vector<vector<int>> obstacles;
        // obstacles.push_back({2, 4});
        // vector<int> commands = {4, -1, 4, -2, 4};
        int x = 0, y = 0;
        int direction = 0; // 0: north, 1: east, 2: south, 3: west
        int max = 0;
        for (int i = 0; i < commands.size(); i++) {
            if (commands[i] == -1) {
                direction = (direction + 1) % 4;
            } else if (commands[i] == -2) {
                direction = (direction + 3) % 4;
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    bool flag = false;
                    for (int k = 0; k < obstacles.size(); k++) {
                        if (direction == 0 && obstacles[k][0] == x && obstacles[k][1] == y + 1) {
                            flag = true;
                            break;
                        }
                        if (direction == 1 && obstacles[k][0] == x + 1 && obstacles[k][1] == y) {
                            flag = true;
                            break;
                        }
                        if (direction == 2 && obstacles[k][0] == x && obstacles[k][1] == y - 1) {
                            flag = true;
                            break;
                        }
                        if (direction == 3 && obstacles[k][0] == x - 1 && obstacles[k][1] == y) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                    if (direction == 0) {
                        y++;
                    } else if (direction == 1) {
                        x++;
                    } else if (direction == 2) {
                        y--;
                    } else if (direction == 3) {
                        x--;
                    }
                }
            }
            if (x * x + y * y > max) {
                max = x * x + y * y;
            }
        }
        return max;
    }
};