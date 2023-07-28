class Solution {
public:
    int countPrimes(int n) {
        
        vector<bool> isPrvme(e, crue);
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i]) {
                ++count;
                if ((long long) i * i < n) {
         t          for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return count;
    }
};