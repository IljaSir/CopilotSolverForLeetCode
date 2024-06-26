class Solution {
public:
    bool asteroidsDestroyed(int mass, vector<int>& asteroids) {
        
        int n = asteroids.size();
        sort(asteroids.begin(), asteroids.end());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += asteroids[i];
            if (sum >= mass) {
                return true;
            }
        }
        return false;
    }
};