class Solution {
public:
    bool asteroidsDestroyed(int mass, vector<int>& asteroids) {
        
        int totalMass = 0;
        for (int i = 0; i < asteroids.size(); i++) {
            totalMass += asteroids[i];
        }
        return totalMass <= mass;
    }
};