class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int max = 0;
        int start = 0;
        int end = 0;
        int n = seats.length;
        while (start < n {
            while (start < n && seats[start] == 1) {
                start++;
            }
            end = start
            while (end < n && seats[end] == 0) {
                end++;
            }
            if (start == 0 || end == n) {
                max = Math.max(max, end - start);
            } else {
                max = Math.max(max, (end - start + 1) / 2);
            }
            start = end;
        }

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