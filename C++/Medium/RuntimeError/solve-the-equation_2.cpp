class Solution {
public:
    string solveEquation(string equation) {
        
        int i = 0;
        int x = 0;
        int n = 0;
        while (i < equation.size()) {
            int j = i;
            while (j < equation.size() && equation[j] != '+' && equation[j] != '-' && equation[j] != '=') {
                ++j;
            }
            string s = equation.substr(i, j - i);
            int k = 0;
            while (k < s.size() && s[k] != 'x') {
                ++k;
            }
            int a = 0;
            int b = 0;
            if (k == s.size()) {
                b = stoi(s);
            } else if (k == 0) {
                a = 1;
            } else if (k == 1) {
                if (s[0] == '+') {
                    a = 1;
                } else if (s[0] == '-') {
                    a = -1;
                } else {
                    a = stoi(s.substr(0, k));
                }
            } else {
                a = stoi(s.substr(0, k));
            }
            if (j == equation.size() || equation[j] == '=') {
                n -= b;
            } else {
                if (equation[j] == '+') {
                    n -= b;
                } else {
                    n += b;
                    a = -a;
                }
            }
            if (j < equation.size() && equation[j] != '=') {
                ++j;
            }
            i = j;
            x += a;
        }
        if (x == 0) {
            if (n == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + to_string(n / x);
        }
    }
};