class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        
        int n = plants.size();
        int ans = 0;
        int water = 0;
        for (int i=0; i<n; i++) {
            int need = plants[i] - water;
            if (need > 0) {
                ans += 1 + 2 * i;
                water = capacity;
            }
            water -= plants[i];
        }
        return ans;
    }
};