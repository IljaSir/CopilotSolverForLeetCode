class Solution {
public:
    int mySqrt(int x) {
        
        int l = 0;
        int r = x;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
};