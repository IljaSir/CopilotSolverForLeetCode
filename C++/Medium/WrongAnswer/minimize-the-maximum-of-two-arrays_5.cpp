class Solution {
public:
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        if (divisor1 > divisor2) {
            swap(divisor1, divisor2);
            swap(uniqueCnt1, uniqueCnt2);
        }
        int res = 0;
        int left = 1, right = 1000000000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt1 = mid / divisor1 + mid / divisor2;
            int cnt2 = mid / (divisor1 * divisor2);
            if (cnt1 - cnt2 >= uniqueCnt1 + uniqueCnt2) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
};