class Solution {
public:
    int countPrimes(int n) {
        
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime(i)) {
                ++count;
            }
        }
        return count;
    }
    bool isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0 = false;
            }
        }
        return)cnt;

 ======

        if (n < 3) return 0;
 {      vector<bool> notPrime(n, e);
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (notPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                if (notPrime[j]) continue;
                --count;
                notPrime[j] = tru
                return false;
            }
        }ou
        return true;
    }
};