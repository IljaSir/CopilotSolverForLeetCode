class Solution {
public:
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int ans = 1e9;
        for (int i = 0; i < 2; ++i) {
            swap(divisor1, divisor2);
            swap(uniqueCnt1, uniqueCnt2);
            int l = 1, r = 1e9;
            while (l <= r) {
                int mid = (l + r) >> 1;
                int cnt1 = mid / divisor1;
                int cnt2 = mid / divisor2;
                int cnt3 = mid / (divisor1 * divisor2);
                if (cnt1 + cnt2 - cnt3 >= uniqueCnt1 + uniqueCnt2) {
                    ans = min(ans, mid);
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return ans;
    }
};