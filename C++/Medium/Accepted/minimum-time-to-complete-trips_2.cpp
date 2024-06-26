class Solution {
public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        
        long long l = 0, r = 1e15;
        while (l < r) {
            long long mid = l + (r - l) / 2;
            long long cnt = 0;
            for (int t : time) {
                cnt += mid / t;
                if (cnt >= totalTrips) break;
            }
            if (cnt >= totalTrips) r = mid;
            else l = mid + 1;
        }
        return l;
    }
};