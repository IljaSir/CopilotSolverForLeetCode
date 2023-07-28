class Solution {
public:
    int countSpecialNumbers(int n) {
        
        int cnt = 0;
        for (int i = 1; i <= n; ++i) {
            if (isSpecial(i)) {
                ++cnt;
            }
        }
        return cnt;
    }
    
    bool isSpecial(int n) {
        int a, b, c;
        if (n < 10) {
            return true;
        } else if (n < 100) {
            a = n / 10;
            b = n % 10;
            return a != b;
        } else if (n < 1000) {
            a = n / 100;
            b = n % 100 / 10;
            c = n % 10;
            return a != b && a != c && b != c;
        } else if (n < 10000) {
            a = n / 1000;
            b = n % 1000 / 100;
            c = n % 100 / 10;
            int d = n % 10;
            return a != b && a != c && a != d && b != c && b != d && c != d;
        } else if (n < 100000) {
            a = n / 10000;
            b = n % 10000 / 1000;
            c = n % 1000 / 100;
            int d = n % 100 / 10;
            int e = n % 10;
            return a != b && a != c && a != d && a != e && b != c && b != d && b != e && c != d && c != e && d != e;
        } else {
            a = n / 100000;
            b = n % 100000 / 10000;
            c = n % 10000 / 1000;
            int d = n % 1000 / 100;
            int e = n % 100 / 10;
            int f = n % 10;
            return a != b && a != c && a != d && a != e && a != f && b != c && b != d && b != e && b != f && c != d && c != e && c != f && d != e && d != f && e != f;
        }
    }
};