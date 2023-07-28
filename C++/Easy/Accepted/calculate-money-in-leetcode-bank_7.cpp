class Solution {
public:
    int totalMoney(int n) {
        
        int w = n / 7;
        int r = n % 7;
        int s = 0;
        for (int i = 0; i < w; i++) {
            int t = i + 1;
            s += t * 7 + 21;
        }
        for (int i = 0; i < r; i++) {
            int t = w + i + 1;
            s += t;
        }
        return s;
    }
};