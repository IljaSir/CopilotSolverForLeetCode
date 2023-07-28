class Solution {
public:
    int latestTimeCatchTheBus(vector<int>& buses, vector<int>& passengers, int capacity) {
        
        int i = 0, j = 0, n = buses.size(), m = passengers.size();
        int cnt = 0, ans = 0;
        sort(buses.begin(), buses.end());
        sort(passengers.begin(), passengers.end());
        while (i < n && j < m) {
            if (buses[i] >= passengers[j]) {
                cnt++;
                j++;
            }
            else {
                cnt--;
                i++;
            }
            if (cnt == capacity) {
                ans = buses[i];
                cnt--;
                i++;
            }
        }
        return ans;
    }
};