class Solution {
public:
    int countSpecialNumbers(int n) {
        
        int a = 0, b = 0, c = 0;
        for (int i = 1; i <= n; i++) {
            if (i < 10) {
                a++;
            } else if (i < 100) {
                b++;
            } else if (i < 1000) {
                c++;
            }
        }
        return a + b + c;
    }
};