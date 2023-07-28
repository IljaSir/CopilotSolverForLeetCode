class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        int count = 0;
        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);
            for (int p : primes) {
                if (p == bits) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}