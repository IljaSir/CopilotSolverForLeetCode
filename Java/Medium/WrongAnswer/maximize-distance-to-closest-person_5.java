class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int n = seats.length;
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                if (i == 0 || seats[i - 1] == 0) {
                    max = Math.max(max, count);
                } else {
                    max = Math.max(max, (count + 1) / 2);
                }
                count = 0;
            }
        }
        if (count > 0) {
            max = Math.max(max, count);
        }
        return max;
    }
}