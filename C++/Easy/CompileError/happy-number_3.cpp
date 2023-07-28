class Solution {
public:
    bool isHappy(int n) {
        
        int x = n;
        int y = n;
        while (x > 1) {
            x = cal(x);
            if (x == 1) {
                return true;
            }
            y = cal(cal(y));
            if (y == 1) {
                return true;
            }
            if (x == y) {
                return false;
            }
        }
        return true;
    }
};