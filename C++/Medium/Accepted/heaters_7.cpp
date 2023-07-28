class Solution {
public:
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        
        sort(heaters.begin(), heaters.end());
        int max = 0;
        for (int i = 0; i < houses.size(); i++) {
            int left = 0;
            int right = heaters.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (heaters[mid] < houses[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int dist1 = (right == 0) ? INT_MAX : houses[i] - heaters[right - 1];
            int dist2 = (right == heaters.size()) ? INT_MAX : heaters[right] - houses[i];
            max = std::max(max, std::min(dist1, dist2));
        }
        return max;
    }
};