class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        
        vector<int> stack;
        for (int i = 0; i < asteroids.size(); i++) {
            if (stack.empty() || asteroids[i] > 0) {
                stack.push_back(asteroids[i]);
            } else {
                while (true) {
                    int last = stack.back();
                    if (last < 0) {
                        stack.push_back(asteroids[i]);
                        break;
                    } else if (last == -asteroids[i]) {
                        stack.pop_back();
                        break;
                    } else if (last > -asteroids[i]) {
                        break;
                    } else {
                        stack.pop_back();
                        if (stack.empty()) {
                            stack.push_back(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        return stack;
    }
};