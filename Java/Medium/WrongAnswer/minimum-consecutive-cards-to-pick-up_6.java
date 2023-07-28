class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int[] cardCount = new int[1000000];
        for (int i = 0; i < cards.length; i++) {
            cardCount[cards[i]]++;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < cardCount.length; i++) {
            if (cardCount[i] > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        int count = 0;
        for (int i = min; i <= max; i++) {
            if (cardCount[i] == 0) {
                count++;
            } else {
                count = 0;
            }
        }
        return count == 0 ? -1 : count;
    }
}