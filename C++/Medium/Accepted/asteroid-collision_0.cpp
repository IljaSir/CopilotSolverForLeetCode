class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        
        vector<int> result;
        for (int i = 0; i < asteroids.size(); i++) {
            if (asteroids[i] > 0) {
                result.push_back(asteroids[i]);
            } else {
                bool isCollided = false;
                while (!result.empty() && result.back() > 0) {
                    if (result.back() > -asteroids[i]) {
                        isCollided = true;
                        break;
                    } else if (result.back() == -asteroids[i]) {
                        isCollided = true;
                        result.pop_back();
                        break;
                    } else {
                        result.pop_back();
                    }
                }
                if (!isCollided) {
                    result.push_back(asteroids[i]);
                }
            }
        }
        return result;
    }
};