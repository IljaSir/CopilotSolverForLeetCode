class Solution {
    public int getMaximumConsecutive(int[] coins) {
        
        Arrays.sort(coins);
        int max = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > max + 1) {
                break;
            }
            max += coins[i];
        }
        return max + 1;
    }
}