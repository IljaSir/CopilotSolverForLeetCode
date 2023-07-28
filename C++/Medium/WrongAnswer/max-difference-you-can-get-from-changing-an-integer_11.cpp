class Solution {
public:
    int maxDiff(int num) {
        
        int a = num, b = num;
        int x = num, y = num;
        int i = 0;
        while (x > 0) {
            int d = x % 10;
            if (d > 0) {
                a = a - d * pow(10, i);
                a = a + 9 * pow(10, i);
                break;
            }
            i++;
            x /= 10;
        }
        i = 0;
        while (y > 0) {
            int d = y % 10;
            if (d > 1) {
                b = b - d * pow(10, i);
                b = b + 1 * pow(10, i);
                break;
            }
            i++;
            y /= 10;
        }
        return a - b;
    }
};