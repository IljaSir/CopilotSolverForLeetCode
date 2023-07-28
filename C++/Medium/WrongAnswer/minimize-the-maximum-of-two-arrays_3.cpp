class Solution {
public:
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        if (divisor1 > divisor2) {
            std::swap(divisor1, divisor2);
            std::swap(uniqueCnt1, uniqueCnt2);
        }
        int64_t lo = 0;
        int64_t hi = 1e18;
        while (lo < hi) {
            int64_t mid = lo + (hi - lo) / 2;
            int64_t cnt1 = mid / divisor1;
            int64_t cnt2 = mid / divisor2;
            int64_t cnt3 = mid / (divisor1 * divisor2);
            if (cnt1 + cnt2 - cnt3 < uniqueCnt1 + uniqueCnt2) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
};