class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int min = 0;
        int max = Integer.MAX_VALUE;
        while (min < max) {
            int mid = (min + max) / 2;
            if (valid(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}