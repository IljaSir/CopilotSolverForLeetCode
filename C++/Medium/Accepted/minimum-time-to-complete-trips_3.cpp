class Solution {
public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        
        long long l = 0, r = 1e14;
        while (l < r) {
            long long m = l + (r - l) / 2;
            long long cnt = 0;
            for (int t : time) {
                cnt += m / t;
            }
            if (cnt >= totalTrips) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
};