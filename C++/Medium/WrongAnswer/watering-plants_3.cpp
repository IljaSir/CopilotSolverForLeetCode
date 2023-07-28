class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        
        int steps = 0;
        int water = 0;
        for (int i = 0; i < plants.size(); i++) {
            if (water < plants[i]) {
                steps += 2 * (i + 1);
                water = capacity;
            }
            water -= plants[i];
            steps++;
        }
        return steps - 1;
    }
};