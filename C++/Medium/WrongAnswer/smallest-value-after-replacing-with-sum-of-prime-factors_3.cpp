class Solution {
public:
    int smallestValue(int n) {
        
        if (n == 2) return n;
        if (n % 2 == 0) return 2;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return i;
        }
        return n;
    }
    int minPrimeFactorSum(int n) {
        int sum = 0;
        while (n > 1) {
            int smallest = smallestValue(n);
            sum += smallest;
            n /= smallest;
        }
        return sum;
    }
};