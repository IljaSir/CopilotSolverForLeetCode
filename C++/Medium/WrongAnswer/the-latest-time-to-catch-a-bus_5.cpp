class Solution {
public:
    int latestTimeCatchTheBus(vector<int>& buses, vector<int>& passengers, int capacity) {
        
        int n = buses.size();
        int m = passengers.size();
        sort(buses.begin(), buses.end());
        sort(passengers.begin(), passengers.end());
        int i = 0;
        int j = 0;
        int cnt = 0;
        int ans = 0;
        while (i < n && j < m) {
            if (buses[i] >= passengers[j]) {
                cnt++;
                ans = max(ans, passengers[j]);
                j++;
            } else {
                cnt--;
                i++;
            }
            if (cnt == capacity) {
                cnt = 0;
                i++;
            }
        }
        if (j < m) {
            ans = max(ans, passengers[m - 1]);
        }
        return ans;
    }
};