class Solution {
public:
    int totalMoney(int n) {
        
        int w = n / 7;
        int r = n % 7;
        int ans = 0;
        for (int i = 0; i < w; i++) {
            ans += 28 + i * 7;
        }
        for (int i = 0; i < r; i++) {
            ans += w + i + 1;
        }
        return ans;
    }
};