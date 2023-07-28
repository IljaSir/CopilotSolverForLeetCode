class Solution {
public:
    int romanToInt(string s) {
        
        int result = 0;
        int n = s.size();
        for (int i = 0; i < n; i++) {
            char c = s[i];
            if (c == 'I') {
                if (i + 1 < n && s[i + 1] == 'V') {
                    result += 4;
                    i++;
                } else if (i + 1 < n && s[i + 1] == 'X') {
                    result += 9;
                    i++;
                } else {
                    result += 1;
                }
            } else if (c == 'V') {
                result += 5;
            } else if (c == 'X') {
                if (i + 1 < n && s[i + 1] == 'L') {
                    result += 40;
                    i++;
                } else if (i + 1 < n && s[i + 1] == 'C') {
                    result += 90;
                    i++;
                } else {
                    result += 10;
                }
            } else if (c == 'L') {
                result += 50;
            } else if (c == 'C') {
                if (i + 1 < n && s[i + 1] == 'D') {
                    result += 400;
                    i++;
                } else if (i + 1 < n && s[i + 1] == 'M') {
                    result += 900;
                    i++;
                } else {
                    result += 100;
                }
            } else if (c == 'D') {
                result += 500;
            } else if (c == 'M') {
                result += 1000;
            }
        }
        return result;
    }
};