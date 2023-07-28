class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        
        int[] ret = new int[2];
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = a + b + c - max - min;
        if (max - min == 2) {
            ret[0] = 0;
        } else if (max - min == 1) {
            ret[0] = 1;
        } else if (max - min == 3) {
            ret[0] = 1;
        } else {
            ret[0] = 2;
        }
        ret[1] = max - mid - 1 + mid - min - 1;
        return ret;
    }
}