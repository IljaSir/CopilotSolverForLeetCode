class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int[] count = new int[1000001];
        int min = Integer.MAX_VALUE;
        for (int card : cards) {
            count[card]++;
            if (count[card] >= 2) {
                min = 0;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                int j = i + 1;
                while (j < count.length && count[j] == 0) {
                    j++;
                }
                if (j < count.length) {
                    min = Math.min(min, j - i);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}