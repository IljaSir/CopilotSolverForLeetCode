class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        
        vector<int> delta(1001);
        for (auto& trip: trips) {
            delta[trip[1]] += trip[0];
            delta[trip[2]] -= trip[0];
        }
        for (int i = 0; i < 1001; ++i) {
            capacity -= delta[i];
            if (capacity < 0) return false;
        }
        return true;
    }
};