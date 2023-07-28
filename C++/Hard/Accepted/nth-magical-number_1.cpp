class Solution {
public:
    int nthMagicalNumber(int n, int a, int b) {
        
        int c = a * b / gcd(a, b);
        long long l = 0, r = 1e15;
        while (l < r) {
            long long mid = (l + r) >> 1;
            if (mid / a + mid / b - mid / c >= n) r = mid;
            else l = mid + 1;
        }
        return l % (int)(1e9 + 7);
    }
};