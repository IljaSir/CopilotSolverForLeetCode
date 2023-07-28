class Solution {
    public int getMaximumConsecutive(int[] coins) {
        
        Arrays.sort(coins);
        int n = coins.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (coins[i] > max + 1) {
                break;
            }
            max += coins[i];
        }
        return max + 1;
    }
}