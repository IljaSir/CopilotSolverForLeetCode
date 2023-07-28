class Solution {
    public int[] numMovesStonesII(int[] stones) {
        
        Arrays.sort(stones);
        int n = stones.length;
        int max = Math.max(stones[n-1] - stones[1] - n + 2, stones[n-2] - stones[0] - n + 2);
        int min = max;
        int i = 0, j = 0;
        while (j < n) {
            while (stones[j] - stones[i] + 1 > n) {
                i++;
            }
            if (j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                min = Math.min(min, 2);
            } else {
                min = Math.min(min, n - (j - i + 1));
            }
            j++;
        }
        return new int[]{min, max};
    }
}