class Solution {
public:
    int countGoodNumbers(long long n) {
        
        if (n == 1) return 5;
        if (n % 2) return 5 * countGoodNumbers(n - 1) % 1000000007;
        long long t = countGoodNumbers(n / 2);
        return t * t % 1000000007;
    }
};