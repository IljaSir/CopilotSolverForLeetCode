class Solution {
public:
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        if (divisor1 > divisor2) {
            swap(divisor1, divisor2);
            swap(uniqueCnt1, uniqueCnt2);
        }
        if (uniqueCnt1 > uniqueCnt2) {
            swap(uniqueCnt1, uniqueCnt2);
        }
        if (uniqueCnt1 == 0) {
            return 0;
        }
        int left = 1, right = 1e9;
        while (left < right) {
            int mid = (left + right) / 2;
            int n1 = mid / divisor1;
            int n2 = mid / divisor2;
            int n12 = mid / (divisor1 * divisor2);
            if (n1 + n2 - n12 >= uniqueCnt1 + uniqueCnt2) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};