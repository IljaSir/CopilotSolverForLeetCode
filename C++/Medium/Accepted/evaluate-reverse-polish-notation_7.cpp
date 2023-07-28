class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        
        stack<int> s;
        int a, b;
        for (string& token : tokens) {
            if (token == "+") {
                a = s.top(); s.pop();
                b = s.top(); s.pop();
                s.push(a + b);
            } else if (token == "-") {
                a = s.top(); s.pop();
                b = s.top(); s.pop();
                s.push(b - a);
            } else if (token == "*") {
                a = s.top(); s.pop();
                b = s.top(); s.pop();
                s.push(a * b);
            } else if (token == "/") {
                a = s.top(); s.pop();
                b = s.top(); s.pop();
                s.push(b / a);
            } else {
                s.push(stoi(token));
            }
        }
        return s.top();
    }
};