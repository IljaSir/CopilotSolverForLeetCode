class Solution {
public:
    int latestTimeCatchTheBus(vector<int>& buses, vector<int>& passengers, int capacity) {
        
        sort(buses.begin(), buses.end());
        sort(passengers.begin(), passengers.end());
        int n = buses.size(), m = passengers.size();
        int i = 0, j = 0, cnt = 0;
        int res = 0;
        while (i < n && j < m) {
            if (buses[i] >= passengers[j]) {
                if (cnt < capacity) {
                    res = max(res, passengers[j]);
                    ++cnt;
                    ++j;
                } else {
                    ++i;
                }
            } else {
                --cnt;
                ++i;
            }
        }
        while (j < m) {
            if (cnt < capacity) {
                res = max(res, passengers[j]);
                ++cnt;
                ++j;
            } else {
                break;
            }
        }
        return res;
    }
};