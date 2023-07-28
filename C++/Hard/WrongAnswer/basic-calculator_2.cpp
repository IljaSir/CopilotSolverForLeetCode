class Solution {
public:
    int calculate(string s) {
        
        stack<int> st;
        int res = 0;
        int sign = 1;
        int n = s.size();
        for (int i = 0; i < n; ++i) {
            if (isdigit(s[i])) {
                int num = 0;
                while (i < n && isdigit(s[i])) {
                    num = num * 10 + (s[i] - '0');
                    ++i;
                }
                res += sign * num;
                --i;
            } else if (s[i] == '+') {
                sign = 1;
            } else if (s[i] == '-') {
                sign = -1;
            } else if (s[i] == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (s[i] == ')') {
                res = st.top() * res + st.top();
                st.pop();
                st.pop();
            }
        }
        return res;
    }
};