class Solution {
public:
    int latestTimeCatchTheBus(vector<int>& buses, vector<int>& passengers, int capacity) {
        
        int n = buses.size();
        int m = passengers.size();
        int ans = 0;
        sort(buses.begin(), buses.end());
        sort(passengers.begin(), passengers.end());
        int i = 0;
        for (int j = 0; j < m; ++j) {
            while (i < n && buses[i] < passengers[j]) {
                ++i;
            }
            if (i == 0) {
                continue;
            }
            int bus = buses[i - 1];
            int cur = bus - passengers[j];
            if (capacity >= j + 1) {
                ans = max(ans, cur);
            }
        }
        return ans;
    }
};