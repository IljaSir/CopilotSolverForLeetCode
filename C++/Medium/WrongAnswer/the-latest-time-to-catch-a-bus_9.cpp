class Solution {
public:
    int latestTimeCatchTheBus(vector<int>& buses, vector<int>& passengers, int capacity) {
        
        int n = buses.size();
        int m = passengers.size();
        vector<pair<int, int>> bus(n);
        for (int i = 0; i < n; ++i) {
            bus[i] = { buses[i], i };
        }
        vector<pair<int, int>> pass(m);
        for (int i = 0; i < m; ++i) {
            pass[i] = { passengers[i], i };
        }
        sort(bus.begin(), bus.end());
        sort(pass.begin(), pass.end());
        int ans = 0;
        vector<int> b(n, 0);
        vector<int> p(m, 0);
        for (int i = 0, j = 0; i < n; ++i) {
            while (j < m && pass[j].first <= bus[i].first) {
                ++b[bus[i].second];
                ++j;
            }
            if (b[bus[i].second] > 0) {
                --b[bus[i].second];
                ++p[pass[j - 1].second];
                ans = max(ans, pass[j - 1].first);
            }
        }
        return ans;
    }
};