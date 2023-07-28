class Solution {
    public int[] memLeak(int memory1, int memory2) {
        
        int t = 1;
        while (memory1 >= t || memory2 >= t) {
            if (memory1 >= memory2) {
                memory1 -= t;
            } else {
                memory2 -= t;
            }
            t++;
        }
        return new int[]{t, memory1, memory2};
    }
}