class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int[] count = new int[1000001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int card : cards) {
            count[card]++;
            min = Math.min(min, card);
            max = Math.max(max, card);
        }
        int result = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            if (count[i] > 1) {
                result = 0;
            } else if (count[i] == 1) {
                result = Math.min(result, 1);
            } else {
                result = Math.min(result, 2);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}