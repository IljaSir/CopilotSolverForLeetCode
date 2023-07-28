class Solution {
public:
    int maxDiff(int num) {
        
        int a = num, b = num;
        int x = -1, y = -1;
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (x == -1 && a % 10 == i) {
                    a -= i;
                    a += j;
                    x = j;
                }
                if (y == -1 && b % 10 == i) {
                    b -= i;
                    b += j;
                    y = j;
                }
                a /= 10;
                b /= 10;
            }
        }
        return max(a, b) - min(a, b);
    }
};