class Solution {
    public int maxCoins(int[] piles) {
        
        Arrays.sort(piles);
        int sum = 0;
        int index = piles.length - 2;
        for (int i = 0; i < piles.length / 3; i++) {
            sum += piles[index];
            index -= 2;
        }
        return sum;
    }
}