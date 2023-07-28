class Solution {
public:
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        
        sort(heaters.begin(), heaters.end());
        int result = 0;
        for (int house : houses) {
            int left = 0, right = heaters.size() - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (heaters[mid] < house) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int dist1 = abs(heaters[left] - house);
            int dist2 = INT_MAX;
            if (left + 1 < heaters.size()) {
                dist2 = abs(heaters[left + 1] - house);
            }
            result = max(result, min(dist1, dist2));
        }
        return result;
    }
};