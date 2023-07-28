class Solution {
public:
    bool isRationalEqual(string s, string t) {
        
        double a = 0, b = 0;
        int i = 0, j = 0;
        while (i < s.size() && s[i] != '(') {
            if (s[i] == '.') {
                i++;
                break;
            }
            a = a * 10 + s[i++] - '0';
        }
        while (j < t.size() && t[j] != '(') {
            if (t[j] == '.') {
                j++;
                break;
            }
            b = b * 10 + t[j++] - '0';
        }
        double x = 0, y = 0;
        int m = 0, n = 0;
        while (i < s.size() && s[i] != ')') {
            x = x * 10 + s[i++] - '0';
            m++;
        }
        while (j < t.size() && t[j] != ')') {
            y = y * 10 + t[j++] - '0';
            n++;
        }
        for (int k = 0; k < max(m, n); k++) {
            x *= 10;
            y *= 10;
        }
        return a + x / pow(10, m) == b + y / pow(10, n);
    }
};