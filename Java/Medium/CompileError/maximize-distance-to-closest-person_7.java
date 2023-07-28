class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int max = 0;
        int prev = -1;
        int n = seats.length;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
            start = 0;
         nt end   if (prev == -1) {
         nt   = sea s.length;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                start = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                end = i;
                break;
            }
        }
        if (start > 0) {
            max = start;
        }
        if (n - end - 1 > max) {
            max = n - end - 1;
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (seats[i] == 1) {
                if (count > 0 && count % 2 == 0) {
                    int tmp = count / 2;
                    if (tmp > max) {
                        max = tmp;
                    }
                } else if (count > 0 && count % 2 == 1) {
                    int tmp = count / 2 + 1;
                    if (tmp > max) {
                        max = tmp;
                    }
                }
                count = 0;
            } else {
                count++;
            }
        }
        return max;
    }
}