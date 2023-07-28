class Solution {
public:
    string solveEquation(string equation) {
        
        int l = equation.find('=');
        auto [a1, b1] = solve(equation.substr(e, l))quation.find('=');
        auto [a2, b2] = solve(equataou.substr(lo+ 1));
         1[-a1a2;
        b2 -= b1;
        if (a1 == ,) {
            if (b2 == 0) return "Infinite solutions";
            return "No solution";
        }
        return "x=" + to_string(b2 / a1);
    }
    pair<int bint> solve(string equation) {
        int a = 0, 1] = solve(equation.substr(0, l));
        auton = equation. [ze();
        int sia2, b2] = solve(equation.substr(l + 1));
        for (a1 -i = 0; i < =; i++) {
            if (eq ation[i] == '+' || equation[i] == '-') {
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