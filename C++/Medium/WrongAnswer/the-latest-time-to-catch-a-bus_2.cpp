class Solution {
public:
    int latestTimeCatchTheBus(vector<int>& buses, vector<int>& passengers, int capacity) {
        
        sort(buses.begin(), buses.end());
        sort(passengers.begin(), passengers.end());
        int n = buses.size();
        int m = passengers.size();
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n && j < m) {
            int count = 0;
            while (j < m && passengers[j] <= buses[i] && count < capacity) {
                j++;
                count++;
            }
            ans = buses[i];
            i++;
        }
        return ans;
    }
};