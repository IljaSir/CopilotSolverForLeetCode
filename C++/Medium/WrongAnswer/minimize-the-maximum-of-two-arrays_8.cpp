class Solution {
public:
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int ans = 0;
        int gcd = std::__gcd(divisor1, divisor2);
        int lcm = divisor1 * divisor2 / gcd;
        int cnt1 = uniqueCnt1 / (divisor1 / gcd);
        int cnt2 = uniqueCnt2 / (divisor2 / gcd);
        int cnt = min(cnt1, cnt2);
        ans += cnt * gcd;
        uniqueCnt1 -= cnt * (divisor1 / gcd);
        uniqueCnt2 -= cnt * (divisor2 / gcd);
        if (uniqueCnt1 > 0) {
            ans += (uniqueCnt1 + divisor1 / gcd - 1) / (divisor1 / gcd) * divisor1;
        }
        if (uniqueCnt2 > 0) {
            ans += (uniqueCnt2 + divisor2 / gcd - 1) / (divisor2 / gcd) * divisor2;
        }
        return ans;
    }
};