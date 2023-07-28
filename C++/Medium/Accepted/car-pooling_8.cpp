class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        
        int n = trips.size();
        vector<int> a(1001, 0);
        for (auto& t : trips) {
            a[t[1]] += t[0];
            a[t[2]] -= t[0];
        }
        int c = 0;
        for (auto& x : a) {
            c += x;
            if (c > capacity) return false;
        }
        return true;
    }
};