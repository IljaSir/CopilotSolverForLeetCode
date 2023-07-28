class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        int count = 0;
        for(int i = left; i <= right; i++) {
            if(isPrime(countBits(i)))
                count++;
        }
        return count;
    }
    private int countBits(int n) {
        int count = 0;
        while(n > 0) {
            if((n & 1) == 1)
                count++;
            n >>= 1;
        }
        return count;
    }
    private boolean isPrime(int n) {
        if(n == 1)
            return false;
        if(n == 2)
            return true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}