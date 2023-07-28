class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int low = 0;
        int high = (int) 1e9;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean check(int mid, int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int cnt1 = mid / divisor1 + mid / divisor2;
        int cnt2 = mid / lcm(divisor1, divisor2);
        return cnt1 - cnt2 + uniqueCnt1 + uniqueCnt2 >= mid;
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