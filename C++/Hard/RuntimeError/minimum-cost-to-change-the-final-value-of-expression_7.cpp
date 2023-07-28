class Solution {
public:
    int minOperationsToFlip(string expression) {
        
        int res = 0;
        stack<int> stk;
        for(int i = expression.size() - 1; i >= 0; --i) {
            char c = expression[i];
            if(c == ')') {
                stk.push(0);
            } else if(c == '(') {
                int val = stk.top();
                stk.pop();
                stk.pop();
                stk.push(val);
            } else if(c == '&') {
                stk.push(0);
            } else if(c == '|') {
                stk.push(1);
            } else {
                int val = c - '0';
                if(!stk.empty()) {
                    int op = stk.top();
                    stk.pop();
                    if(op == 0) {
                        val &= stk.top();
                        stk.pop();
                    } else {
                        val |= stk.top();
                        stk.pop();
                    }
                }
                stk.push(val);
            }
        }
        while(stk.size() > 1) {
            int val = stk.top();
            stk.pop();
            int op = stk.top();
            stk.pop();
            if(op == 0) {
                val &= stk.top();
                stk.pop();
            } else {
                val |= stk.top();
                stk.pop();
            }
            stk.push(val);
        }
        int val = stk.top();
        stk.pop();
        while(val != 0) {
            val = (val & 1) ^ 1;
            ++res;
        }
        return res;
    }
};