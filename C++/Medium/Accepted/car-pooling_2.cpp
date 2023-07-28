class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        
        vector<int> m(1001, 0);
        for (auto &t : trips) {
            m[t[1]] += t[0];
            m[t[2]] -= t[0];
        }
        for (int i = 0; i < 1001; ++i) {
            capacity -= m[i];
            if (capacity < 0) return false;
        }
        return true;
    }
};