class Solution {
public:
    string decodeString(string s) {
        
        string res;
        stack<string> stk;
        int n = s.size();
        for (int i = 0; i < n; i++) {
            if (s[i] == ']') {
                string str;
                while (stk.top() != "[") {
                    str = stk.top() + str;
                    stk.pop();
                }
                stk.pop();
                string num;
                while (!stk.empty() && stk.top() >= "0" && stk.top() <= "9") {
                    num = stk.top() + num;
                    stk.pop();
                }
                int k = stoi(num);
                string t;
                while (k--) {
                    t += str;
                }
                stk.push(t);
            } else {
                string t(1, s[i]);
                stk.push(t);
            }
        }
        while (!stk.empty()) {
            res = stk.top() + res;
            stk.pop();
        }
        return res;
    }
};