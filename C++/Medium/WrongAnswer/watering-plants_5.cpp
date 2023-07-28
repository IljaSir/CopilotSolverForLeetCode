class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        
        int ans = 0;
        int n = plants.size();
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (cur < plants[i]) {
                ans += 1 + i - cur;
                cur = i;
            }
            cur += plants[i];
        }
        return ans;
    }
};