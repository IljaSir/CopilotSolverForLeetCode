class Solution {
    public int smallestValue(int n) {
        
        int primeFactorsSum = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                primeFactorsSum += i;
                n /= i;
            }
        }
        return primeFactorsSum;
    }
}