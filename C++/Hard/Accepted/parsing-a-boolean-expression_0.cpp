class Solution {
public:
    bool parseBoolExpr(string expression) {
        
        stack<char> s;
        for (char c : expression) {
            if (c == ')') {
                vector<bool> v;
                while (s.top() != '(') {
                    if (s.top() == 't') v.push_back(true);
                    else if (s.top() == 'f') v.push_back(false);
                    s.pop();
                }
                s.pop();
                char op = s.top();
                s.pop();
                bool r = false;
                if (op == '&') r = true;
                for (bool b : v) {
                    if (op == '&') r = r && b;
                    else if (op == '|') r = r || b;
                    else if (op == '!') r = !b;
                }
                s.push(r ? 't' : 'f');
            }
            else s.push(c);
        }
        return s.top() == 't';
    }
};