class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        
        stack<int> s;
        for (auto& token : tokens) {
            if (token == "+" || token == "-" || token == "*" || token == "/") {
                int a = s.top(); s.pop();
                int b = s.top(); s.pop();
                int c = 0;
                if (token == "+") c = a + b;
                else if (token == "-") c = b - a;
                else if (token == "*") c = a * b;
                else if (token == "/") c = b / a;
                s.push(c);
            } else {
                s.push(stoi(token));
            }
        }
        return s.top();
    }
};