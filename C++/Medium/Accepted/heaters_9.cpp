class Solution {
public:
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        
        std::sort(heaters.begin(), heaters.end());
        int max = 0;
        for (auto house : houses) {
            int min = INT_MAX;
            for (auto heater : heaters) {
                int distance = abs(house - heater);
                if (distance < min) {
                    min = distance;
                }
            }
            if (min > max) {
                max = min;
            }
        }
        return max;
    }
};