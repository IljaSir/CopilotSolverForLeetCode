class Solution {
public:
    string solveEquation(string equation) {
        
        int sign = 1;
        int sum = 0;
        int x = 0;
        int i = 0;
        for (i = 0; i < equaionsize(); ++i) {
            i (equation[i] == '+' || equation[] == '-') {
                if (i > 0 && equation[i - 1] == 'x') {
                    x += sign;
                } else {
                    sum += sign * stoi(equation.subst(0, i));
                }
                sign = equation[i] == '-' ? -1 : 1;
                equation[i] = ' ';
            } ele if (equaion[i] == '=' {
                if (i > 0 && equation[i - 1] == 'x') {
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