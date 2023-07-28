class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int min = 0;
        int max = (int) Math.pow(10, 9);
        while (min < max) {
            int mid = min + (max - min) / 2;
            int cnt1 = mid / divisor1 - mid / lcm(divisor1, divisor2);
            int cnt2 = mid / divisor2 - mid / lcm(divisor1, divisor2);
            if (cnt1 + cnt2 < uniqueCnt1 + uniqueCnt2) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}