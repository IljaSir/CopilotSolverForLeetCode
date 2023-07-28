class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        
        vector<int> result;
        for (auto& a : asteroids) {
            if (result.empty() || a > 0) {
                result.push_back(a);
            } else {
                while (true) {
                    int prev = result.back();
                    if (prev < 0) {
                        result.push_back(a);
                        break;
                    } else if (prev == -a) {
                        result.pop_back();
                        break;
                    } else if (prev > -a) {
                        break;
                    } else {
                        result.pop_back();
                        if (result.empty()) {
                            result.push_back(a);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
};