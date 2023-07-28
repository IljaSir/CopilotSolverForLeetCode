class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        
        vector<int> v(1001, 0);
        for (auto t : trips) {
            v[t[1]] += t[0];
            v[t[2]] -= t[0];
        }
        int sum = 0;
        for (auto i : v) {
            sum += i;
            if (sum > capacity) return false;
        }
        return true;
    }
};