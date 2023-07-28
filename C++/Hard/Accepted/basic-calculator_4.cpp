class Solution {
public:
    int calculate(string s) {
        
        int n = s.size();
        int res = 0;
        int sign = 1;
        int num = 0;
        stack<int> st;
        for (int i = 0; i < n; i++) {
            if (isdigit(s[i])) {
                num = num * 10 + (s[i] - '0');
            } else if (s[i] == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (s[i] == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (s[i] == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (s[i] == ')') {
                res += sign * num;
                res *= st.top();
                st.pop();
                res += st.top();
                st.pop();
                num = 0;
            }
        }
        res += sign * num;
        return res;
    }
};