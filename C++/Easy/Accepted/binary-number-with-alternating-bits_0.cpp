class Solution {
public:
    bool hasAlternatingBits(int n) {
        
        int last = n % 2;
        n /= 2;
        while (n) {
            if (n % 2 == last) {
                return false;
            }
            last = n % 2;
            n /= 2;
        }
        return true;
    }
};