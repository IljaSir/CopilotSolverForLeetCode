class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        
        int n = plants.size();
        int steps = 0, water = 0;
        for (int i = 0; i < n; i++) {
            water -= plants[i];
            steps++;
            if (water < 0) {
                steps += (-water);
                water = capacity;
            }
            water -= plants[i];
            steps++;
        }
        return steps;
    }
};