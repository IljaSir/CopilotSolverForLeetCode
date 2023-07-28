class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int l = 1, r = 1000000000;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}