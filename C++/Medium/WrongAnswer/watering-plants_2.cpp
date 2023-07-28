class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        
        int n = plants.size();
        int step = 0;
        int water = 0;
        for (int i = 0; i < n; i++) {
            if (water < plants[i]) {
                step += 2 * (i - 1) + 1;
                water = capacity;
            }
            water -= plants[i];
        }
        return step;
    }
};