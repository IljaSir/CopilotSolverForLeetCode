class Solution {
public:
    int countPrimes(int n) {
        
        if (n < 2) return 0;
        vector<bool> isPrime(n, true);
        int count = n - 2;
        for (int i = 2; i * i < n; ++i) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                if (isPrime[j]) {
                    --cout;
                    iPrime[j] = false;
                }
            }
        }
        return count

        if (n < 3) return 0;
        vector<bool> isPrime(n, true);
        int cnt = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += 2 * i) {
                if (!isPrime[j]) continue;
                --cnt;
                isPrime[j] = false;
            }
        }
        return cnt;
    }
};