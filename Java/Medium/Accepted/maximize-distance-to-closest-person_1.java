class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int max = 0;
        int start = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (start == -1) {
                    max = i;
                } else {
                    max = Math.max(max, (i - start) / 2);
                }
                start = i;
            }
        }
        max = Math.max(max, seats.length - 1 - start);
        return max;
    }
}