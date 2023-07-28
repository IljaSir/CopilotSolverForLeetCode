class Solution {
public:
    int countPrimes(int n) {
        
        if (n < 3) return 0;
        vector<bool> notPrime(n, false);
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (notPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                if (notPrime[j]) continue;
                --count;
                notPrime[j] = true;
            }
        }
        return count;
    }
};