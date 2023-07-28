class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int l = 1, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt1 = mid / divisor1, cnt2 = mid / divisor2;
            int both = mid / (divisor1 * divisor2);
            if (cnt1 + cnt2 - both >= uniqueCnt1 + uniqueCnt2) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}