class Solution {
public:
    long long minimumPerimeter(long long neededApples) {
        
        long long n = sqrt(neededApples / 3.0) + 1;
        long long res = 0;
        for (int i = 1; i <= n; ++i) {
            long long cur = 1LL * (4 * i - 3) * (4 * i - 3);
            res += cur;
        }
        return res * 2;
    }
};