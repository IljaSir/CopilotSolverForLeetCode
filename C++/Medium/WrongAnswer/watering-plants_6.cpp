class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        
        int n = plants.size();
        int water = 0;
        int steps = 0;
        for (int i = 0; i < n; i++) {
            water -= plants[i];
            steps++;
            if (water < 0) {
                water = capacity;
                steps += 2 * (i + 1);
            }
        }
        return steps;
    }
};