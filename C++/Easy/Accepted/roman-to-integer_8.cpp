class Solution {
public:
    int romanToInt(string s) {
        
        int result = 0;
        int i = 0;
        while (i < s.size()) {
            if (i + 1 < s.size()) {
                if (s[i] == 'I' && s[i + 1] == 'V') {
                    result += 4;
                    i += 2;
                    continue;
                }
                if (s[i] == 'I' && s[i + 1] == 'X') {
                    result += 9;
                    i += 2;
                    continue;
                }
                if (s[i] == 'X' && s[i + 1] == 'L') {
                    result += 40;
                    i += 2;
                    continue;
                }
                if (s[i] == 'X' && s[i + 1] == 'C') {
                    result += 90;
                    i += 2;
                    continue;
                }
                if (s[i] == 'C' && s[i + 1] == 'D') {
                    result += 400;
                    i += 2;
                    continue;
                }
                if (s[i] == 'C' && s[i + 1] == 'M') {
                    result += 900;
                    i += 2;
                    continue;
                }
            }
            if (s[i] == 'I') {
                result += 1;
            }
            if (s[i] == 'V') {
                result += 5;
            }
            if (s[i] == 'X') {
                result += 10;
            }
            if (s[i] == 'L') {
                result += 50;
            }
            if (s[i] == 'C') {
                result += 100;
            }
            if (s[i] == 'D') {
                result += 500;
            }
            if (s[i] == 'M') {
                result += 1000;
            }
            i++;
        }
        return result;
    }
};