class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        if (divisor1 > divisor2) {
            return minimizeSet(divisor2, divisor1, uniqueCnt2, uniqueCnt1);
        }
        long low = 0, high = (long) 1e18;
        while (low < high) {
            long mid = (low + high) / 2;
            if (check(divisor1, divisor2, uniqueCnt1, uniqueCnt2, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }

    private boolean check(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2, long max) {
        long cnt1 = max / divisor1 - (max / lcm(divisor1, divisor2));
        long cnt2 = max / divisor2 - (max / lcm(divisor1, divisor2));
        return cnt1 + cnt2 >= uniqueCnt1 + uniqueCnt2 && cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2;
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}