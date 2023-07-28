class Solution {
public:
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        if (divisor1 > divisor2) {
            swap(divisor1, divisor2);
            swap(uniqueCnt1, uniqueCnt2);
        }
        int ans = 0;
        for (int i = 1; i <= uniqueCnt1; i++) {
            int l = i + 1, r = uniqueCnt1 + uniqueCnt2;
            while (l < r) {
                int mid = (l + r) / 2;
                if (check(divisor1, divisor2, i, mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans = max(ans, max(i, l));
        }
        return ans;
    }
};