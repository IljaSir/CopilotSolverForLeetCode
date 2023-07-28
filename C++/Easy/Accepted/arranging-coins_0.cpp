class Solution {
public:
    int arrangeCoins(int n) {
        
        long long l = 0, r = n;
        while (l < r) {
            long long mid = l + (r - l + 1) / 2;
            if (mid * (mid + 1) / 2 <= n) l = mid;
            else r = mid - 1;
        }
        return l;
    }
};