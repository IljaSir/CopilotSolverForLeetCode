class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        int count = 0;
        for (int i = left; i <= right; i++) {
            count += isPrime(Integer.bitCount(i)) ? 1 : 0;
        }
        return count;
    }

    private boolean isPrime(int n) {
        if (n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13 || n == 17 || n == 19) {
            return true;
        }
        return false;
    }
}