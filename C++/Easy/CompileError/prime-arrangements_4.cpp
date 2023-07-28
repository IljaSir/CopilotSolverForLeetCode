class Solution {
public:
    int numPrimeArrangements(int n) {
        
        int count = 0;
        for (int i = 2; i <= n; ++i)
            if (isPrime(i))
                ++count;
        long long result = 1;
        for (int i = 2; i <= count; ++i)
            result = (result * i) % 1000000007;
        for (int i = 2; i <= n - count; ++i)
            result = (result * i) % 1000000007;
        return result;
    }
};