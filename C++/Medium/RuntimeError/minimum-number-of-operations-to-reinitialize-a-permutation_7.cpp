class Solution {
public:
    int reinitializePermutation(int n) {
        
        int cnt = 0;
        int i = 1;
        do {
            if (i < n / 2) {
                i *= 2;
            } else {
                i = n - i - 1;
            }
            cnt++;
        } while (i != 1);
        return cnt;
    }
};