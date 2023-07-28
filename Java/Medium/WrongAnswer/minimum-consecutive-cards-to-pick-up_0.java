class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < cards.length; i++) {
            min = Math.min(min, cards[i]);
            max = Math.max(max, cards[i]);
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < cards.length; i++) {
            count[cards[i] - min]++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2) {
                ans = 0;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 1) {
                int j = i + 1;
                while (j < count.length && count[j] == 0) {
                    j++;
                }
                if (j < count.length) {
                    ans = Math.min(ans, j - i);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}