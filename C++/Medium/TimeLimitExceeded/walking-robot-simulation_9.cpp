class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        
        int x = 0, y = 0, d = 0, max = 0;
        for (auto cmd : commands) {
            switch (cmd) {
                case -2:
                    d = (d - 1 + 4) % 4;
                    break;
                case -1:
                    d = (d + 1) % 4;
                    break;
                default:
                    while (cmd--) {
                        int x1 = x, y1 = y;
                        switch (d) {
                            case 0:
                                y1++;
                                break;
                            case 1:
                                x1++;
                                break;
                            case 2:
                                y1--;
                                break;
                            case 3:
                                x1--;
                                break;
                        }
                        bool blocked = false;
                        for (auto o : obstacles) {
                            if (o[0] == x1 && o[1] == y1) {
                                blocked = true;
                                break;
                            }
                        }
                        if (!blocked) {
                            x = x1;
                            y = y1;
                        }
                    }
            }
            int d2 = x * x + y * y;
            if (d2 > max) max = d2;
        }
        return max;
    }
};