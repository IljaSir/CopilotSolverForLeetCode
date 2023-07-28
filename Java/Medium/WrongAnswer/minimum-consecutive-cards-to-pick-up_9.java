class Solution {
    public int minimumCardPickup(int[] cards) {
        
        if (cards.length < 2) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int[] count = new int[1000001];
        int[] first = new int[1000001];
        int[] last = new int[1000001];
        for (int i = 0; i < cards.length; i++) {
            count[cards[i]]++;
            if (count[cards[i]] == 1) {
                first[cards[i]] = i;
            }
            last[cards[i]] = i;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                min = Math.min(min, last[i] - first[i] + 1);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}