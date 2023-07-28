class Solution {
public:
    int reinitializePermutation(int n) {
        
        int ans = 0;
        int cur = 1;
        do {
            ans++;
            if (cur < n / 2) {
                cur = 2 * cur;
            } else {
                cur = 2 * (cur - n / 2) + 1;
            }
        } while (cur != 1);
        return ans;
    }
};