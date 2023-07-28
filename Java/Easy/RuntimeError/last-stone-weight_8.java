class Solution {
    public int lastStoneWeight(int[] stones) {
        
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        int i = stones.length - 1;
        while (stones[i] == 0) {
            i--;
        }
        int y = stones[i];
        stones[i] = 0;
        i--;
        while (stones[i] == 0) {
            i--;
        }
        int x = stones[i];
        stones[i] = 0;
        if (x == y) {
            return lastStoneWeight(stones);
        } else {
            stones[i] = y - x;
            return lastStoneWeight(stones);
        }
    }
}