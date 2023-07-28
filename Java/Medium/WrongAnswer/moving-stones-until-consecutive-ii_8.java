class Solution {
    public int[] numMovesStonesII(int[] stones) {
        
        Arrays.sort(stones);
        int n = stones.length;
        int low = Integer.MAX_VALUE;
        int high = Math.max(stones[n - 1] - stones[1] + 1 - n + 2, stones[n - 2] - stones[0] + 1 - n + 2);
        for (int i = 0, j = 0; i < n; i++) {
            while (stones[i] - stones[j] + 1 > n) {
                j++;
            }
            if (stones[i] - stones[j] + 1 == n - 1 && stones[i] - stones[j] + 1 > 2) {
                low = Math.min(low, 2);
            } else {
                low = Math.min(low, n - (i - j + 1));
            }
        }
        return new int[] {low, high};
    }
}