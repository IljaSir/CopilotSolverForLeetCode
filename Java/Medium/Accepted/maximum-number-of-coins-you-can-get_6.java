class Solution {
    public int maxCoins(int[] piles) {
        
        int n = piles.length;
        Arrays.sort(piles);
        int i = 0, j = n - 2;
        int sum = 0;
        while (i < j) {
            sum += piles[j];
            i++;
            j -= 2;
        }
        return sum;
    }
}