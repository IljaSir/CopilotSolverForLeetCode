class Solution {
public:
    bool parseBoolExpr(string expression) {
        
        stack<char> s;
        for (char c : expression) {
            if (c == ')') {
                bool t = s.top() == 't';
                s.pop(); // pop t or f
                s.pop(); // pop & or |
                while (s.top() != '(') {
                    bool cur = s.top() == 't';
                    s.pop();
                    if (s.top() == '&') t &= cur;
                    else t |= cur;
                }
                s.pop(); // pop (
                s.push(t ? 't' : 'f');
            } else if (c != ',') {
                s.push(c);
            }
        }
        return s.top() == 't';
    }
};