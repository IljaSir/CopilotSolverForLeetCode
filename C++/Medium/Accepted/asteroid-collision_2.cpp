class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        
        vector<int> result;
        for (int i = 0; i < asteroids.size(); ++i) {
            if (asteroids[i] > 0) {
                result.push_back(asteroids[i]);
            } else {
                bool explode = false;
                while (!result.empty() && result.back() > 0) {
                    if (result.back() == -asteroids[i]) {
                        result.pop_back();
                        explode = true;
                        break;
                    } else if (result.back() < -asteroids[i]) {
                        result.pop_back();
                    } else {
                        explode = true;
                        break;
                    }
                }
                if (!explode) {
                    result.push_back(asteroids[i]);
                }
            }
        }
        return result;
    }
};