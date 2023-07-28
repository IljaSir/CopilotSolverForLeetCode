class Solution {
    public int[] memLeak(int memory1, int memory2) {
        
        int i = 1;
        while (true) {
            if (memory1 >= memory2) {
                if (memory1 >= i) {
                    memory1 -= i;
                } else {
                    return new int[] {i, memory1, memory2};
                }
            } else {
                if (memory2 >= i) {
                    memory2 -= i;
                } else {
                    return new int[] {i, memory1, memory2};
                }
            }
            i++;
        }
    }
}