class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        
        int n = plants.size();
        int res = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (cur < plants[i]) {
                res += 2 * (i - 1) + 1;
                cur = capacity - plants[i];
            } else {
                cur -= plants[i];
            }
        }
        return res;
    }
};