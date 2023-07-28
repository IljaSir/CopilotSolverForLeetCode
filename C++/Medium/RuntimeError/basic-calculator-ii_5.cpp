class Solution {
public:
    int calculate(string s) {
        
        stack<int> stk;
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.size(); i++) {
            if(isdigit(s[i])) {
                num = num * 10 + s[i] - '0';
            }
            if((!isdigit(s[i]) && s[i] != ' ') || i == s.size() - 1) {
                if(sign == '+') {
                    stk.push(num);
                }
                if(sign == '-') {
                    stk.push(-num);
                }
                if(sign == '*') {
                    int tmp = stk.top();
                    stk.pop();
                    stk.push(tmp * num);
                }
                if(sign == '/') {
                    int tmp = stk.top();
                    stk.pop();
                    stk.push(tmp / num);
                }
                sign = s[i];
                num = 0;
            }
        }
        int res = 0;
        while(!stk.empty()) {
            res += stk.top();
            stk.pop();
        }
        return res;
    }
};