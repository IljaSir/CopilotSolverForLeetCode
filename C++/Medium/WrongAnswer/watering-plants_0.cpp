class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        
        int n = plants.size();
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            if (cur < plants[i]) {
                ans += 2 * i + 1;
                cur = capacity;
            }
            cur -= plants[i];
        }
        return ans;
    }
};