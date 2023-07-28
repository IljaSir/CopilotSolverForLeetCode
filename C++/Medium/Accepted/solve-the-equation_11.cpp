class Solution {
public:
    string solveEquation(string equation) {
        
        int left = 0, right = 0, x = 0;
        int i = 0;
        while (i < equation.size() && equation[i] != '=') {
            int sign = 1;
            if (equation[i] == '+') {
                sign = 1;
                i++;
            } else if (equation[i] == '-') {
                sign = -1;
                i++;
            }
            if (equation[i] == 'x') {
                x += sign;
                i++;
            } else {
                int num = 0;
                while (i < equation.size() && equation[i] >= '0' && equation[i] <= '9') {
                    num = num * 10 + equation[i] - '0';
                    i++;
                }
                if (i < equation.size() && equation[i] == 'x') {
                    x += sign * num;
                    i++;
                } else {
                    left += sign * num;
                }
            }
        }
        i++;
        while (i < equation.size()) {
            int sign = 1;
            if (equation[i] == '+') {
                sign = 1;
                i++;
            } else if (equation[i] == '-') {
                sign = -1;
                i++;
            }
            if (equation[i] == 'x') {
                x -= sign;
                i++;
            } else {
                int num = 0;
                while (i < equation.size() && equation[i] >= '0' && equation[i] <= '9') {
                    num = num * 10 + equation[i] - '0';
                    i++;
                }
                if (i < equation.size() && equation[i] == 'x') {
                    x -= sign * num;
                    i++;
                } else {
                    right += sign * num;
                }
            }
        }
        if (x == 0) {
            if (left == right) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + to_string((right - left) / x);
        }
    }
};