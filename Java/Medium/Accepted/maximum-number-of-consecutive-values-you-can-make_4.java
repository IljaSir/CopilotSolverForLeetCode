class Solution {
    public int getMaximumConsecutive(int[] coins) {
        
        int ans = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > ans) break;
            ans += coin;
        }
        return ans;
    }
}