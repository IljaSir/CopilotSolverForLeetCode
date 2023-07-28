class Solution {
    public int maxCoins(int[] piles) {
        
        int sum = 0;
        Arrays.sort(piles);
        int n = piles.length;
        int i = n - 2;
        while(i >= n/3) {
            sum += piles[i];
            i -= 2;
        }
        return sum;
    }
}