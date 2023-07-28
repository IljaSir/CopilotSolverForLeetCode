class Solution {
public:
    int minFlips(int a, int b, int c) {
        
        int ans = 0;
        while(a || b || c) {
            ans += (a & 1) | (b & 1) != (c & 1);
            ans += (a & 1) & (b & 1) & ((c & 1) == 0);
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return ans;
    }
};