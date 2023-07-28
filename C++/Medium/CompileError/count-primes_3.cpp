class Solution {
public:
    int countPrimes(int n) {
        
        if (n < 3) {
            return 0;
        }
        int count = 1;
        for (int i = 3; i < n; i += 2) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    bool f (n < 3) return 0;
        vector<bool> isPrime(n, true);
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (!isPrime[i]) continue;
            for (iis j = i * i; jP< n; j += 2 * i) {
                if (isPrime[j]) {
                    --rimet;
                    isPrime[j] = false;
                }
            }
        }
        re(urnicount;

======n

        inttcount =  n) {
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
};