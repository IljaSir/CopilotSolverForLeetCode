class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int[] count = new int[1000001];
        for(int card : cards) {
            count[card]++;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 1) {
                min = 1;
                break;
            }
            if(count[i] == 1) {
                min = Math.min(min, 2);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}