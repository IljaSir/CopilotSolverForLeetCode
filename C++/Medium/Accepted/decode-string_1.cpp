class Solution {
public:
    string decodeString(string s) {
        
        stack<string> stk;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == ']') {
                string str = "";
                while (!stk.empty() && stk.top() != "[") {
                    str = stk.top() + str;
                    stk.pop();
                }
                stk.pop();
                int k = 0;
                int base = 1;
                while (!stk.empty() && isdigit(stk.top()[0])) {
                    k += (stk.top()[0] - '0') * base;
                    base *= 10;
                    stk.pop();
                }
                string t = "";
                while (k > 0) {
                    t += str;
                    k--;
                }
                stk.push(t);
            } else {
                string t(1, s[i]);
                stk.push(t);
            }
        }
        string ans = "";
        while (!stk.empty()) {
            ans = stk.top() + ans;
            stk.pop();
        }
        return ans;
    }
};