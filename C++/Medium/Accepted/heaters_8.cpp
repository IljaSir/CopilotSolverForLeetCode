class Solution {
public:
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        
        // sort the houses and heaters
        sort(houses.begin(), houses.end());
        sort(heaters.begin(), heaters.end());
        int i = 0, j = 0, n = houses.size(), m = heaters.size(), res = 0;
        while (i < n) {
            // find the heater that is closest to the current house
            while (j < m - 1 && abs(heaters[j] - houses[i]) >= abs(heaters[j + 1] - houses[i])) ++j;
            res = max(res, abs(heaters[j] - houses[i]));
            ++i;
        }
        return res;
    }
};