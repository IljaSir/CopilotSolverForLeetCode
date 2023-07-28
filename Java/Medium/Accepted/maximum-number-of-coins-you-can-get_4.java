class Solution {
    public int maxCoins(int[] piles) {
        
        Arrays.sort(piles);
        int res = 0;
        int n = piles.length;
        for (int i = 0; i < n / 3; i++) {
            res += piles[n - 2 * i - 2];
        }
        return res;
    }
}