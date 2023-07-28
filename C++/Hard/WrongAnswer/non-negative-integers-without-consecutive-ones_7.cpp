class Solution {
public:
    int findIntegers(int n) {
        
        int a = 0, b = 1, c;
        for (int i = 31; i >= 0; i--) {
            if ((n >> i) & 1) {
                c = a + b;
                a = b;
                b = c;
                if ((n >> (i + 1)) & 1) {
                    break;
                }
            } else {
                a = b;
            }
        }
        return a + b;
    }
};