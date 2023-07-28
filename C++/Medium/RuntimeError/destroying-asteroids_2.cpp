class Solution {
public:
    bool asteroidsDestroyed(int mass, vector<int>& asteroids) {
        
        int n = asteroids.size();
        sort(asteroids.begin(), asteroids.end());
        int i = 0;
        while(i < n && mass >= asteroids[i]) {
            mass += asteroids[i];
            i++;
        }
        return i == n;
    }
};