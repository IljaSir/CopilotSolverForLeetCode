class Solution {
public:
    bool isPalindrome(int x) {
        
        if (x < 0) return false;
        int y = 0;
        int x0 = x;
        while (x0 > 0) {
            y = y * 10 + x0 % 10;
            x0 /= 10;
        }
        return x == y;
    }
};