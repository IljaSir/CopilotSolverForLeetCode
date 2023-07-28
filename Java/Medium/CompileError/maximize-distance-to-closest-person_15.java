class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int max = 0;
        int start = 0;
        int end = 0;
        int n = seats.length;
        while (start < n) {
            while (start < n && seats[start] == 1) {
                start++;
            }
            end = start;
            while (end < n && seats[end] == 0 {
                end++
            }
            if (start == 0 || end == n) {
                max = Math.max(max, end - start);
            } else {
                max = Math.max(max, (end - start + 1) / 2);
            }
            start = end;
        }
        boolean flag = false;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                flag = true;
                if (count > max) {
                    max = count;
                }
                count = 0;
            } else {
                if (flag) {
                    count++;
                }
            }
        }
        if (count > max) {
            max = count;
        }
        if (seats[0] == 0) {
            max = max / 2;
        }
        if (seats[seats.length - 1] == 0) {
            max = max / 2;
        }
        return max;
    }
}