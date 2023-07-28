class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        
        vector<int> stops(1001, 0);
        for (auto trip : trips) {
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }
        for (auto stop : stops) {
            capacity -= stop;
            if (capacity < 0) return false;
        }
        return true;
    }
};