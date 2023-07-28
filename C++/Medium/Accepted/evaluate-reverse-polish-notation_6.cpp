class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        
        stack<int> stk;
        for (auto& token : tokens) {
            if (token == "+" || token == "-" || token == "*" || token == "/") {
                int num2 = stk.top();
                stk.pop();
                int num1 = stk.top();
                stk.pop();
                int result = 0;
                if (token == "+") {
                    result = num1 + num2;
                } else if (token == "-") {
                    result = num1 - num2;
                } else if (token == "*") {
                    result = num1 * num2;
                } else if (token == "/") {
                    result = num1 / num2;
                }
                stk.push(result);
            } else {
                stk.push(stoi(token));
            }
        }
        return stk.top();
    }
};