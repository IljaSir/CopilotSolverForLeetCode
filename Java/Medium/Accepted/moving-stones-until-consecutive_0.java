class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        
        int[] stones = new int[]{a, b, c};
        Arrays.sort(stones);
        if (stones[1] - stones[0] == 1 && stones[2] - stones[1] == 1) {
            return new int[]{0, 0};
        }
        int min = 2;
        if (stones[1] - stones[0] <= 2 || stones[2] - stones[1] <= 2) {
            min = 1;
        }
        return new int[]{min, stones[2] - stones[0] - 2};
    }
}