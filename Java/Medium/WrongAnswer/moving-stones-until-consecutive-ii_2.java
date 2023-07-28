class Solution {
    public int[] numMovesStonesII(int[] stones) {
        
        Arrays.sort(stones);
        int n = stones.length;
        int max = Math.max(stones[n - 1] - stones[1] + 1 - (n - 2), stones[n - 2] - stones[0] + 1 - (n - 2));
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < n; i++) {
            while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n) {
                j++;
            }
            int cost = n - (j - i + 1);
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                cost = 2;
            }
            min = Math.min(min, cost);
        }
        return new int[]{min, max};
    }
}