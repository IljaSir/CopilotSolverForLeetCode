class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19};
        int count = 0;
        for (int i = left; i <= right; i++) {
            int num = i;
            int setBits = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    setBits++;
                }
                num >>= 1;
            }
            for (int prime: primes) {
                if (setBits == prime) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}