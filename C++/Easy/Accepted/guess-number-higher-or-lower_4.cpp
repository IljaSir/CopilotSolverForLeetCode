class Solution {
public:
    int guessNumber(int n) {
        
        int l = 1, r = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int g = guess(m);
            if (g == 0) return m;
            else if (g == 1) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
};