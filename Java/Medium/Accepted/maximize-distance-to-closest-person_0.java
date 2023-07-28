class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int max = 0;
        int last = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (last == -1) {
                    max = i;
                } else {
                    max = Math.max(max, (i - last) / 2);
                }
                last = i;
            }
        }
        if (seats[seats.length - 1] == 0) {
            max = Math.max(max, seats.length - 1 - last);
        }
        return max;
    }
}