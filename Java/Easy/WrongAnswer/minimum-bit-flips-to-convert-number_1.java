class Solution {
    public int minBitFlips(int start, int goal) {
        
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int bit1 = (start >> i) & 1;
            int bit2 = (goal >> i) & 1;
            if (bit1 == bit2) {
                continue;
            }
            if (bit1 == 0) {
                count++;
            } else {
                return -1;
            }
        }
        return count;
    }
}