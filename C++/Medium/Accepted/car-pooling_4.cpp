class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        
        vector<int> d(1001);
        for (auto& t : trips) {
            d[t[1]] += t[0];
            d[t[2]] -= t[0];
        }
        for (int i = 0; i < 1001; i++) {
            capacity -= d[i];
            if (capacity < 0) return false;
        }
        return true;
    }
};