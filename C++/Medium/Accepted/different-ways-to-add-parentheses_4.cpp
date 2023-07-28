class Solution {
public:
    vector<int> diffWaysToCompute(string expression) {
        
        vector<int> res;
        int len = expression.size();
        for (int i = 0; i < len; i++) {
            if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*') {
                vector<int> left = diffWaysToCompute(expression.substr(0, i));
                vector<int> right = diffWaysToCompute(expression.substr(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        if (expression[i] == '+') res.push_back(l + r);
                        else if (expression[i] == '-') res.push_back(l - r);
                        else res.push_back(l * r);
                    }
                }
            }
        }
        if (res.empty()) res.push_back(stoi(expression));
        return res;
    }
};