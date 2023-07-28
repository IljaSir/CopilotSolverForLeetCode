class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        
        int steps = 0;
        int water = capacity;
        for (int i = 0; i < plants.size(); i++) {
            if (water < plants[i]) {
                steps += i * 2;
                water = capacity;
            }
            water -= plants[i];
            steps++;
        }
        return steps;
    }
};