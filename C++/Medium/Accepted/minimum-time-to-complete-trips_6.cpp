class Solution {
public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        
        int n = time.size();
        long long l = 0, r = 1e15;
        while (l < r) {
            long long m = (l + r) >> 1;
            long long cnt = 0;
            for (int i = 0; i < n; ++i) {
                cnt += m / time[i];
                if (cnt >= totalTrips) break;
            }
            if (cnt >= totalTrips) r = m;
            else l = m + 1;
        }
        return l;
    }
};