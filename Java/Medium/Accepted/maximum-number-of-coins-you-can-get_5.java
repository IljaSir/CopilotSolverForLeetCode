class Solution {
    public int maxCoins(int[] piles) {
        
        Arrays.sort(piles);
        int n = piles.length;
        int sum = 0;
        for (int i = 0; i < n / 3; i++) {
            sum += piles[n - 2 - i * 2];
        }
        return sum;
    }
}