class Solution {
public:
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        long long l = 0, r = 1e18;
        while(l < r) {
            long long mid = (l + r) >> 1;
            long long cnt1 = mid / divisor1;
            long long cnt2 = mid / divisor2;
            long long cnt3 = mid / (divisor1 * divisor2);
            if(cnt1 + cnt2 - cnt3 < uniqueCnt1 + uniqueCnt2) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
};