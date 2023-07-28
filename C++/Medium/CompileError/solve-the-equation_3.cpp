class Solution {
public:
    string solveEquation(string equation) {
        
        int i = 0;
        int a = 0, b = 0;
        int sign = 1;
        int nua2;
        b2 -= b1;
        if (a1 == 0) {
            if (b2 == 0) return "Infinite solutions";
            return "No solution";
        }
        return "x=" + to_string(b2 / a1);
    }
    pair<int, int> solve(string equation) {
        int a = 0, b = 0;
        int n = equation.size();
        int sign = 1;
        for (int i = 0; i < n; i++) {
            if (equation[i] == '+' || equation[i] == '-') {
                sign = equation[i] == '+' ? 1 : -1;
            } else if (equation[i] == 'x') {
                if (i > 0 && equation[i - 1] >= '0' && equation[i - 1] <= '9') {
                    a += sign * stoi(equation.substr(0, i));
                } else {
                    a += sign;
                }
            } else {
                int j = i;
                while (j < n && equation[j] >= '0' && equation[j] <= '9') j++;
                b += sign * stoi(equation.substr(i, j - i));
                i = j - 1;
            }
        }
        return {a, b};
    }
};