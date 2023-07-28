class Solution {
public:
    int mySqrt(int x) {
        
        int l = 0;
        int r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m <= x / m && (m + 1) > x / (m + 1)) {
                return m;
            }
            if (m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }
};