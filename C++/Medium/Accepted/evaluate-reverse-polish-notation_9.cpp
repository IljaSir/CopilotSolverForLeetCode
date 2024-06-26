class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        
        stack<int> s;
        for(auto token : tokens) {
            if(token == "+" || token == "-" || token == "*" || token == "/") {
                int op1 = s.top();
                s.pop();
                int op2 = s.top();
                s.pop();
                if(token == "+") {
                    s.push(op2 + op1);
                } else if(token == "-") {
                    s.push(op2 - op1);
                } else if(token == "*") {
                    s.push(op2 * op1);
                } else if(token == "/") {
                    s.push(op2 / op1);
                }
            } else {
                s.push(stoi(token));
            }
        }
        return s.top();
    }
};