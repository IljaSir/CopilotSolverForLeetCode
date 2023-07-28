class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19};
        int count = 0;
        for (int i = left; i <= right; i++) {
            int setBit = 0;
            for (int j = i; j > 0; j >>= 1) {
                setBit += j & 1;
            }
            for (int p : prime) {
                if (setBit == p) {
                    count++;
                }
            }
        }
        return count;
    }
}