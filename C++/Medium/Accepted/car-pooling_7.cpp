class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        
        vector<int> c(1001, 0);
        for (auto& t : trips) {
            c[t[1]] += t[0];
            c[t[2]] -= t[0];
        }
        int s = 0;
        for (auto& x : c) {
            s += x;
            if (s > capacity) return false;
        }
        return true;
    }
};