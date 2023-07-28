class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < plants.size(); i++) {
            if (cur < plants[i]) {
                ans += (i - cur) * 2;
                cur = i;
            }
            cur += plants[i];
        }
        return ans;
    }
};