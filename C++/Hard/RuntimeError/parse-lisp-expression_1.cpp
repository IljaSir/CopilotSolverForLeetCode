class Solution {
public:
    int evaluate(string expression) {
        
        return evaluate(expression, 0, expression.size(), 0).first;
    }
    pair<int, int> evaluate(string &expression, int l, int r, int depth) {
        if (expression[l] != '(') {
            int value = 0;
            int sign = 1;
            if (expression[l] == '-') {
                sign = -1;
                ++l;
            }
            for (int i = l; i < r; ++i) {
                value = value * 10 + expression[i] - '0';
            }
            return {value * sign, r};
        }
        if (expression[l + 1] == 'm') {
            auto [x, i] = evaluate(expression, l + 6, r - 1, depth + 1);
            auto [y, j] = evaluate(expression, i + 1, r - 1, depth + 1);
            return {x * y, j};
        }
        if (expression[l + 1] == 'a') {
            auto [x, i] = evaluate(expression, l + 5, r - 1, depth + 1);
            auto [y, j] = evaluate(expression, i + 1, r - 1, depth + 1);
            return {x + y, j};
        }
        int i = l + 5;
        unordered_map<string, int> values;
        while (i < r - 1) {
            auto [name, j] = evaluate(expression, i + 1, r - 1, depth + 1);
            auto [value, k] = evaluate(expression, j + 1, r - 1, depth + 1);
            values[expression.substr(i + 1, j - i - 1)] = value;
            i = k + 1;
        }
        return evaluate(expression, i + 1, r - 1, depth + 1);
    }
};