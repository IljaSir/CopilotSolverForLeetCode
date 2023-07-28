class Solution {
public:
    int trailingZeroes(int n) {
        
        int cnt = 0;
        long long p = 5;
        while (n >= p) {
            cnt += n / p;
            p *= 5;
        }
        return cnt;
    }
};