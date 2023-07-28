class Solution {
public:
    string solveEquation(string equation) {
        
        int i = 0;
        int a = 0, b = 0;
        int sign = 1;
        int num = 0;
        while (i < equation.size() && equation[i] != '=') {
            if (equation[i] == 'x') {
                a += sign * (num == 0 ? 1 : num);
                num = 0;
            } else if (equation[i] == '+') {
                b += sign * num;
                num = 0;
                sign = 1;
            } else if (equation[i] == '-') {
                b += sign * num;
                num = 0;
                sign = -1;
            } else {
                num = num * 10 + (equation[i] - '0');
            }
            ++i;
        }
        b += sign * num;
        num = 0;
        sign = -1;
        ++i;
        while (i < equation.size()) {
            if (equation[i] == 'x') {
                a += sign * (num == 0 ? 1 : num);
                num = 0;
            } else if (equation[i] == '+') {
                b += sign * num;
                num = 0;
                sign = -1;esult.first));
        }
    }
};