class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int[] count = new int[1000001];
        for (int card : cards) {
            count[card]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 1000001; i++) {
            if (count[i] > 1) {
                int j = 0;
                while (j < cards.length && cards[j] != i) {
                    j++;
                }
                int k = cards.length - 1;
                while (k >= 0 && cards[k] != i) {
                    k--;
                }
                min = Math.min(min, k - j + 1);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}