class Solution {
public:
    int countSpecialNumbers(int n) {
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isSpecial(i)) {
                count++;
            }
        }
        return count;
    }
    bool isSpecial(int n) {
        int mask = 0;
        while (n) {
            int d = n % 10;
            if (mask & (1 << d)) {
                return false;
            }
            mask |= (1 << d);
            n /= 10;
        }
        return true;
    }
};