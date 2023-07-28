class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int[] ans = new int[2];
        int diff = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (i - left >= diff) {
                    break;
                }
                if (diff > i - left) {
                    diff = i - left;
                    ans[0] = left;
                    ans[1] = i;
                }
                left = i;
            }
        }
        return ans;
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}