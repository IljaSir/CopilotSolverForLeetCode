class Solution {
public:
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        
        sort(heaters.begin(), heaters.end());
        int n = heaters.size();
        int res = 0;
        for (auto house : houses) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (heaters[mid] < house) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int dist1 = abs(heaters[l] - house);
            int dist2 = INT_MAX;
            if (l > 0) {
                dist2 = abs(heaters[l - 1] - house);
            }
            res = max(res, min(dist1, dist2));
        }
        return res;
    }
};