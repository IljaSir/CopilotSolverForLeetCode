class Solution {
public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        
        int n = time.size();
        long long l = 0, r = 1e12, ans = 0;
        while(l <= r) {
            long long mid = (l + r) >> 1;
            long long cnt = 0;
            for(int i = 0; i < n; i++) {
                cnt += mid / time[i];
            }
            if(cnt >= totalTrips) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }
};