class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int minDiff = Integer.MAX_VALUE;
        int[] res = new int[2];
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (i - left >= minDiff) {
                    return res;
                }
                res[0] = left;
                res[1] = i;
                minDiff = i - left;
                left = i;
            }
        }
        return res;
    }
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}