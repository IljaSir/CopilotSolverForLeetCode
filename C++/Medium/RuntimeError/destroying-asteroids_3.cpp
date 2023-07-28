class Solution {
public:
    bool asteroidsDestroyed(int mass, vector<int>& asteroids) {
        
        sort(asteroids.begin(), asteroids.end());
        for (auto& asteroid : asteroids) {
            if (mass >= asteroid) {
                mass += asteroid;
            }
        }
        return mass >= asteroids[asteroids.size() - 1];
    }
};