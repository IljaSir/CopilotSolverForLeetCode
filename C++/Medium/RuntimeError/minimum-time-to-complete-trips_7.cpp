class Solution {
public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        
        long long l = 0, r = 1e18;
        while (l < r) {
            long long mid = (l + r) >> 1;
            if (check(time, mid) >= totalTrips) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    long long check(vector<int>& time, long long t) {
        long long ans = 0;
        for (auto& x: time) {
            ans += t / x;
        }
        return ans;
    }
};