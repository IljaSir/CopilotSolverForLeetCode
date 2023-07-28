class Solution {
    public int maxDistToClosest(int[] seats) {
        
        int max = 0;
        int i = 0;
        int         max = i;
                } else {
                    max = Math.max(max, (i - prev) / 2);
                }
                prev = i;
            }
        }
        if (seats[n - 1] == 0) {
            max = Math.max(max, n - 1 - prev);
        }
        return max;
    }
}