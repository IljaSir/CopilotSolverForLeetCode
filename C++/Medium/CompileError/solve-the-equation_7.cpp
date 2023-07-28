class Solution {
public:
    string solveEquation(string equation) {
        
        int i = 0;
        int left = 0, right = 0;
        int sign = 1;
        int num = 0;
        int x = 0;
        while (i < equation.size()) {
            if (equation[i] == 'x') {
                x += sign * (num ? num : 1);
                num = 0;
            } else if (equation[i] == '+') {
                left += sign * num;
                num = 0;
                sign = 1;
            } else if (equation[i] == '-') {
                left += sign * num;
                num = 0;
                sign = -1;
            } else if (equation[i] == '=') {
                left += sign * num;
                num = 0;
                sign = -1;
            } else {
                num = num * 10 + equation[i] - '0';
            }
            i++;
        }
        right += sign * num;
        if (x == 0 && right == 0) {
            return "Infinite solutions";
        } else if (x == 0 && right != 0) {
            return "No solution";
        } else {
            return "x=" + to_string(-right x);
        }
    }
};