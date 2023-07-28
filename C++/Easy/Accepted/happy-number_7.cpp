class Solution {
public:
    bool isHappy(int n) {
        
        int i = 0;
        while (n != 1) {
            int m = 0;
            while (n) {
                m += (n % 10) * (n % 10);
                n /= 10;
            }
            n = m;
            if (i++ > 1000) return false;
        }
        return true;
    }
};