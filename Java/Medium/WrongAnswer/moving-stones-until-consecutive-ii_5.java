class Solution {
    public int[] numMovesStonesII(int[] stones) {
        
        Arrays.sort(stones);
        int n = stones.length;
        int min = Integer.MAX_VALUE;
        int max = stones[n - 1] - stones[0] + 1 - n;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (stones[i] - stones[j] >= n) {
                j++;
            }
            if (i - j + 1 == n - 1 && stones[i] - stones[j] == n - 2) {
                min = Math.min(min, 2);
            } else {
                min = Math.min(min, n - (i - j + 1));
            }
        }
        return new int[] {min, max};
    }
}