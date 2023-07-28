class Solution {
public:
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int d1 = divisor1;
        int d2 = divisor2;
        if (d1 > d2) {
            swap(d1, d2);
            swap(uniqueCnt1, uniqueCnt2);
        }
        int ans = 0;
        int cnt = 0;
        for (int i = 1; i < d1; ++i) {
            int j = d2 - i;
            if (j < d1) {
                cnt += 1;
                ans = max(ans, j);
            }
        }
        if (uniqueCnt1 + uniqueCnt2 - cnt >= d1) {
            ans = max(ans, d1 - 1);
        }
        return ans;
    }
};