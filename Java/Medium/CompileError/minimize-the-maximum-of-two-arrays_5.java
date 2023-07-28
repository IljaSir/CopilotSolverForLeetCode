class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int lo = 0, hi = 1000000000;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int cnt1 = mid / divisor1;
            int cnt2 = mid / divisor2;
            int cnt12 = mid / lcm(divisor1, divisor2);
            if (cnt1 + cnt2 - cnt12 >= uniqueCnt1 + uniqueCnt2) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}