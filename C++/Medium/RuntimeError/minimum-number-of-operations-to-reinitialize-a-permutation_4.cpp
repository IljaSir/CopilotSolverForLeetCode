class Solution {
public:
    int reinitializePermutation(int n) {
        
        int ans = 0;
        int i = 1;
        do {
            if (i < n / 2) {
                i *= 2;
            } else {
                i = n - i - 1;
            }
            ans++;
        } while (i != 1);
        return ans;
    }
};