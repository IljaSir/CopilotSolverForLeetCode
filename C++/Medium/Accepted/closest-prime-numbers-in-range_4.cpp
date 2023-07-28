class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        
        int minDiff = INT_MAX;
        int min1 = -1;
        int min2 = -1;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                int j = i + 1;
                while (j <= right) {
                    if (isPrime(j)) {
                        if (j - i < minDiff) {
                            minDiff = j - i;
                            min1 = i;
                            min2 = j;
                        }
                        break;
                    }
                    j++;
                }
                j = i - 1;
                while (j >= left) {
                    if (isPrime(j)) {
                        if (i - j < minDiff) {
                            minDiff = i - j;
                            min1 = j;
                            min2 = i;
                        }
                        break;
                    }
                    j--;
                }
            }
        }
        return {min1, min2};
    }
    
    bool isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
};