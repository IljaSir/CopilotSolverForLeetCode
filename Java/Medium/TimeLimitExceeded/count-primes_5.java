class Solution {
    public int countPrimes(int n) {
        
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

    private boolean isPrime(int n) {
        if (n % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}