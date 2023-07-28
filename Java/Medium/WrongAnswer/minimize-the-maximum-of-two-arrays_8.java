class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int gcd = gcd(divisor1, divisor2);
        int lcm = divisor1 * divisor2 / gcd;
        int n1 = (int) Math.ceil((double) uniqueCnt1 / (double) lcm);
        int n2 = (int) Math.ceil((double) uniqueCnt2 / (double) lcm);
        int max = Math.max((n1 * divisor1), (n2 * divisor2));
        return max;
    }
    
    private int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}