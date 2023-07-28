class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < seats.length) {
            if (seats[i] == 1) {
                if (j == 0) {
                    max = Math.max(max, i - j);
                } else {
                    max = Math.max(max, (i - j + 1) / 2);
                }
                j = i + 1;
            }
            i++;
        }
        max = Math.max(max, i - j);
        return max;
    }
}