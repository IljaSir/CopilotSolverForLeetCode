class Solution {
    public int minBitFlips(int start, int goal) {
        
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int startBit = (start >> i) & 1;
            int goalBit = (goal >> i) & 1;
            if (startBit != goalBit) {
                count++;
                start ^= 1 << i;
            }
        }
        return start == goal ? count : -1;
    }
}