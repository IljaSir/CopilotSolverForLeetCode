class Solution {
public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        
        long long left = 0;
        long long right = 1e9;
        while (left < right) {
            long long mid = left + (right - left) / 2;
            long long total = 0;
            for (auto t : time) {
                total += mid / t;
            }
            if (total >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};