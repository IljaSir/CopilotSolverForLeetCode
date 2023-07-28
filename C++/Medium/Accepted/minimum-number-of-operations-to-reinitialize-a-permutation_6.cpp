class Solution {
public:
    int reinitializePermutation(int n) {
        
        int cnt = 0;
        int cur = 1;
        while (cnt == 0 || cur != 1) {
            if (cur < n / 2) {
                cur *= 2;
            } else {
                cur = (cur - n / 2) * 2 + 1;
            }
            cnt += 1;
        }
        return cnt;
    }
};