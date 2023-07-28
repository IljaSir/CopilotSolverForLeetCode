class Solution {
public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        
        long long l = *max_element(time.begin(), time.end());
        long long r = 1LL * l * totalTrips;
        while (l < r) {
            long long m = l + (r - l) / 2;
            long long c = 0;
            for (auto t : time) {
                c += m / t;
            }
            if (c >= totalTrips) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
};