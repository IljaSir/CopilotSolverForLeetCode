class Solution {
public:
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        
        sort(heaters.begin(), heaters.end());
        int max_radius = 0;
        for (int house : houses) {
            int left = 0;
            int right = heaters.size() - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (heaters[mid] < house) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }
            int radius = abs(heaters[left] - house);
            if (left > 0) {
                radius = min(radius, abs(heaters[left - 1] - house));
            }
            max_radius = max(max_radius, radius);
        }
        return max_radius;
    }
};