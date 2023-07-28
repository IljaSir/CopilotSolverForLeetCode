class Solution {
public:
    int latestTimeCatchTheBus(vector<int>& buses, vector<int>& passengers, int capacity) {
        
        int n = buses.size();
        int m = passengers.size();
        sort(buses.begin(), buses.end());
        sort(passengers.begin(), passengers.end());
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n && j < m) {
            int bus = buses[i];
            int cnt = 0;
            while (j < m && passengers[j] <= bus && cnt < capacity) {
                ++j;
                ++cnt;
            }
            if (cnt == 0) {
                ++i;
            } else {
                ans = max(ans, passengers[j - 1]);
            }
        }
        return ans;
    }
};