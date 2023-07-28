class Solution {
public:
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        
        sort(heaters.begin(), heaters.end());
        int res = 0;
        for (int house : houses) {
            int i = lower_bound(heaters.begin(), heaters.end(), house) - heaters.begin();
            int dist1 = i - 1 >= 0 ? house - heaters[i - 1] : INT_MAX;
            int dist2 = i < heaters.size() ? heaters[i] - house : INT_MAX;
            res = max(res, min(dist1, dist2));
        }
        return res;
    }
};