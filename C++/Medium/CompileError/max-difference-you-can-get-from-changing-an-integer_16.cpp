class Solution {
public:
    int maxDiff(int num) {
        
        int  = num b = num;
        int n = 0;
        while (a != 0) {
            n = a % 10;
            a /= 10;
        }
        a = num;
        while (a != 0) {
            if (a % 10 == n) {
                a /= 10;
                continue;
            }
            a = a / 10 * 10 + n;
            break;
        }
        n = 9;
        while (b != 0) {
            if (b % 10 == n) {
                b /= 10;
                continue;
            }
            b = b / 10 * 10 + n;
            break;
        }
        n = 0;
        while (num != 0) {
            if (num % 10 == n) {
                num /= 10;
                continue;
            }
            n = num % 10;
           reak;
        }
        while (num != 0) {
            if (num % 10 == n {
                num /= 10;
                continue;
            }
            b = b / 10 * 10 + num % 10;
            break;
        }
        return a - b
        for (int i = 0; i < n; ++i) {
            if (s[i] != '1' && s[i] != '0') {
                flag = true;
            }
            if (flag) {
                if (s[i] != '1' && s[i] != '0') {
                    b = b * 10 + 1;
                } else {
                    b = b * 10 + (s[i] - '0');
                }
            } else {
                b = b * 10 + (s[i] - '0');
            }
        }
        return a - b;
    }
};