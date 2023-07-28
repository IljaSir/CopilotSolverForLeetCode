class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int[] count = new int[1000001];
        for (int i = 0; i < cards.length; i++) {
            count[cards[i]]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2) {
                int start = 0;
                int end = cards.length - 1;
                int c = 0;
                while (cards[start] != i) {
                    start++;
                    c++;
                }
                while (cards[end] != i) {
                    end--;
                    c++;
                }
                min = Math.min(min, c);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}