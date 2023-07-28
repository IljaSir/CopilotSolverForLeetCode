class Solution {
public:
    bool hasAlternatingBits(int n) {
        
        int last = n % 2;
        n = n / 2;
        while (n > 0) {
            int current = n % 2;
            if (last == current) {
                return false;
            }
            last = current;
            n = n / 2;
        }
        return true;
    }
};