class Solution {
public:
    string solveEquation(string equation) {
        
        auto pos = equation.find('=');
        auto left = equation.substr(0, pos);
        auto right = equation.substr(pos + 1);
        auto leftResult = solve(left);
        auto rightResult = solve(right);
        if (leftResult.first == rightResult.first) {
            if (leftResult.second == rightResult.second) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + to_string((rightResult.second - leftResult.second) / (leftResult.first - rightResult.first));
        }
    }
};