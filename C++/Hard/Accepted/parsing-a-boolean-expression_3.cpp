class Solution {
public:
    bool parseBoolExpr(string expression) {
        
        stack<char> s;
        for (char c : expression) {
            if (c != ')') {
                s.push(c);
            }
            else {
                string tmp;
                while (s.top() != '(') {
                    tmp = s.top() + tmp;
                    s.pop();
                }
                s.pop();
                char op = s.top();
                s.pop();
                bool res = (op == '&') ? true : false;
                for (int i = 0; i < tmp.length(); i++) {
                    if (tmp[i] == ',') {
                        continue;
                    }
                    else if (tmp[i] == 't') {
                        if (op == '&') {
                            res &= true;
                        }
                        else if (op == '|') {
                            res |= true;
                        }
                        else {
                            res = !true;
                        }
                    }
                    else if (tmp[i] == 'f') {
                        if (op == '&') {
                            res &= false;
                        }
                        else if (op == '|') {
                            res |= false;
                        }
                        else {
                            res = !false;
                        }
                    }
                    else {
                        res = parseBoolExpr(tmp);
                        break;
                    }
                }
                s.push(res ? 't' : 'f');
            }
        }
        return s.top() == 't';
    }
};