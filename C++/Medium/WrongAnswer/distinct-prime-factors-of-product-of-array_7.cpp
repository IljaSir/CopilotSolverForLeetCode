class Solution {
public:
    int distinctPrimeFactors(vector<int>& nums) {
        
        int max = 0;
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }
        int count = 0;
        for (int i = 2; i <= max; i++) {
            bool isPrime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                bool hasFactor = false;
                for (int n : nums) {
                    if (n % i == 0) {
                        if (hasFactor) {
                            hasFactor = false;
                            break;
                        }
                        hasFactor = true;
                    }
                }
                if (hasFactor) {
                    count++;
                }
            }
        }
        return count;
    }
};