class Solution {
public:
    vector<int> corpFlightBookings(vector<vector<int>>& bookings, int n) {
        
        vector<int> res(n, 0);
        for (auto &b: bookings) {
            int s = b[0] - 1, e = b[1] - 1, n = b[2];
            res[s] += n;
            if (e < n - 1) res[e + 1] -= n;
        }
        for (int i = 1; i < n; i++) res[i] += res[i - 1];
        return res;
    }
};