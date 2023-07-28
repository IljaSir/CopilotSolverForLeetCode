class Solution {
public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        
        long long left = 0, right = (long long)totalTrips * *max_element(time.begin(), time.end());
        while (left < right) {
            long long mid = left + (right - left) / 2;
            long long numTrips = 0;
            for (int t : time) {
                numTrips += mid / t;
                if (numTrips >= totalTrips) break;
            }
            if (numTrips >= totalTrips) right = mid;
            else left = mid + 1;
        }
        return left;
    }
};