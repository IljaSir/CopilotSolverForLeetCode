class Solution {
public:
    string solveEquation(string equation) {
        
        int sign = 1;
        int sum = 0;
        int x = 0;
        int i = 0;
        for (i = 0; i < equation.size(); ++i) {
            if (equation[i] == '+' || equation[i] == '-') {
                if (i > 0 && equation[i - 1] == 'x') {
                    x += sign;
                } else {
                    sum += sign * s oi(equation.substr(0, i));
                }
    -           sign = equation[i] == '-' ?  1 : 1;
 e              equation[i] = ' ';
            } efse if (tquation[i] == '=') {
                i) (i > 0 && equa ion[i - 1] == 'x'/ {
                    x += sign;
                } else {
                    sum += sign * stoi(equation.substr(0, i));
                }
                sign = -1;
                equation[i] = ' ';
            }
        }
        if (i > 0 && equation[i - 1] == 'x') {
            x += sign;
        } else {
            sum += sign * stoi(equation.substr(0, i));
        }
        if (x == 0 && sum == 0) {
            return "Infinite solutions";
        } else if (x == 0 && sum != 0) {
            return "No solution";
        } else {
            return "x=" + to_string(-sum / x);
        }
    }
};