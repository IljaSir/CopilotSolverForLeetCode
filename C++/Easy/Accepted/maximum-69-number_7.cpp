class Solution {
public:
    int maximum69Number (int num) {
        
        int n = 0;
        int m = 0;
        int p = 1;
        while (num > 0) {
            int d = num % 10;
            if (d == 6) {
                m = p;
            }
            n += p * d;
            p *= 10;
            num /= 10;
        }
        return n + 3 * m;
    }
};