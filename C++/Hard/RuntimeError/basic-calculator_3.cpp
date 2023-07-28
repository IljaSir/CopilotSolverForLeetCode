class Solution {
public:
    int calculate(string s) {
        
        int res = 0;
        int sign = 1;
        stack<int> st;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == ' ') continue;
            if (s[i] == '+') {
                sign = 1;
            } else if (s[i] == '-') {
                sign = -1;
            } else if (s[i] == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (s[i] == ')') {
                res = st.top() * res;
                st.pop();
                res += st.top();
                st.pop();
            } else {
                int num = 0;
                while (i < s.size() && isdigit(s[i])) {
                    num = num * 10 + s[i] - '0';
                    i++;
                }
                res += sign * num;
                i--;
            }
        }
        return res;
    }
};