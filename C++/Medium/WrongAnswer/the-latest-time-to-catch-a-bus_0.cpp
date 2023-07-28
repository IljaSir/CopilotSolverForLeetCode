class Solution {
public:
    int latestTimeCatchTheBus(vector<int>& buses, vector<int>& passengers, int capacity) {
        
        sort(buses.begin(), buses.end());
        sort(passengers.begin(), passengers.end());
        int i = 0, j = 0, res = 0;
        while (i < buses.size() && j < passengers.size()) {
            int cnt = 0;
            while (j < passengers.size() && passengers[j] <= buses[i]) {
                ++j;
                ++cnt;
                if (cnt == capacity) {
                    break;
                }
            }
            res = buses[i];
            ++i;
        }
        return res;
    }
};