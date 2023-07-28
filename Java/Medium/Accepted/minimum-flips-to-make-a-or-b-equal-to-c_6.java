class Solution {
    public int minFlips(int a, int b, int c) {
        
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int aBit = (a >> i) & 1;
            int bBit = (b >> i) & 1;
            int cBit = (c >> i) & 1;
            if (cBit == 0) {
                count += aBit + bBit;
            } else {
                if (aBit == 0 && bBit == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}