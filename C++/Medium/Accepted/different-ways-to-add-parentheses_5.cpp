class Solution {
public:
    vector<int> diffWaysToCompute(string expression) {
        
        vector<int> res;
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char c = expression[i];
            if (c == '+' || c == '-' || c == '*') {
                vector<int> res1 = diffWaysToCompute(expression.substr(0, i));
                vector<int> res2 = diffWaysToCompute(expression.substr(i + 1));
                for (int j = 0; j < res1.size(); j++) {
                    for (int k = 0; k < res2.size(); k++) {
                        if (c == '+') {
                            res.push_back(res1[j] + res2[k]);
                        } else if (c == '-') {
                            res.push_back(res1[j] - res2[k]);
                        } else {
                            res.push_back(res1[j] * res2[k]);
                        }
                    }
                }
            }
        }
        if (res.empty()) {
            res.push_back(atoi(expression.c_str()));
        }
        return res;
    }
};