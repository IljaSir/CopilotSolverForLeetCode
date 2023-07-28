class Solution {
public:
    bool isPalindrome(int x) {
        
        if (x < 0) return false;
        int rev = 0, ori = x;
        while (x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev == ori;
    }
};