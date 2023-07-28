class Solution {
    public int minBitFlips(int start, int goal) {
        
        // 1. get the bit length of start and goal
        int startBitLen = getBitLength(start);
        int goalBitLen = getBitLength(goal);
        int bitLen = Math.max(startBitLen, goalBitLen);
        // 2. get the bit array of start and goal
        int[] startBitArr = getBitArr(start, bitLen);
        int[] goalBitArr = getBitArr(goal, bitLen);
        // 3. get the flip count
        int flipCount = 0;
        for (int i = 0; i < bitLen; i++) {
            if (startBitArr[i] != goalBitArr[i]) {
                flipCount++;
                flipBit(startBitArr, i);
            }
        }
        return flipCount;
    }

    private int getBitLength(int num) {
        int bitLen = 0;
        while (num > 0) {
            bitLen++;
            num >>= 1;
        }
        return bitLen;
    }

    private int[] getBitArr(int num, int bitLen) {
        int[] bitArr = new int[bitLen];
        for (int i = 0; i < bitLen; i++) {
            bitArr[i] = num & 1;
            num >>= 1;
        }
        return bitArr;
    }

    private void flipBit(int[] bitArr, int i) {
        if (i < 0 || i >= bitArr.length) {
            return;
        }
        bitArr[i] = bitArr[i] == 0 ? 1 : 0;
    }
}