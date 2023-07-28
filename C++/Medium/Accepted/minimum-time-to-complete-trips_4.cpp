class Solution {
public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        
        long long lo = 0, hi = 1LL * totalTrips * *max_element(time.begin(), time.end());
        while (lo < hi) {
            long long mi = lo + (hi - lo) / 2;
            long long trips = 0;
            for (int t : time) {
                trips += mi / t;
                if (trips >= totalTrips) break;
            }
            if (trips >= totalTrips) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }
};