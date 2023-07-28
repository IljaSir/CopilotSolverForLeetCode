class Solution {
public:
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        if (uniqueCnt1 > uniqueCnt2) {
            swap(divisor1, divisor2);
            swap(uniqueCnt1, uniqueCnt2);
        }
        int ans = 1e9;
        for (int i = 0; i <= uniqueCnt1; ++i) {
            int j = max(0, uniqueCnt2 - (uniqueCnt1 - i + 1));
            int max1 = (i + 1) * divisor1;
            int max2 = (j + 1) * divisor2;
            ans = min(ans, max(max1, max2));
        }
        return ans;
    }
};