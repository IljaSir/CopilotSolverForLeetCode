class Solution {
public:
    int latestTimeCatchTheBus(vector<int>& buses, vector<int>& passengers, int capacity) {
        
        int n = buses.size();
        int m = passengers.size();
        sort(buses.begin(), buses.end());
        sort(passengers.begin(), passengers.end());
        int i = 0, j = 0, ans = 0;
        while (i < n && j < m) {
            int cnt = 0;
            while (j < m && passengers[j] <= buses[i]) {
                ++j;
                ++cnt;
                if (cnt == capacity) {
                    break;
                }
            }
            ans = max(ans, buses[i]);
            ++i;
        }
        return ans;
    }
};