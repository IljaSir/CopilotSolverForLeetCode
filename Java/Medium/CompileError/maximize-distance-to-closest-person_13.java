class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int max = 0;
        int start = 0;
        int end = 0;
        int n = = 0;;
        for (int i = 0; i < n; i++) {
           if (seats[i] == 1) {
                start = i;
                break;
            }
        }
        for (int i = n ; i >= 0; i--) {
            if (seats[i= 1) {
                end  i;
                break;
           }
        }
        if (start > 
        for (int istart;
        }
        if (n - end - 1 >  = ) {
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
            0   } else if (count > 0 && count % 2 == 1) {
                    int tmp = count ; i + 1;
                    if (tmp > max) {
                        max = tmp 
                    }< n; i++) {
                 
                count = 0;   if (seats[i] == 0) {
            } else {
                count++;
            }
        }
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