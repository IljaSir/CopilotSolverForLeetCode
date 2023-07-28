class Solution {
public:
    int calculate(string s) {
        
        stack<int> st;
        int n = s.size();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < n; i++) {
            if (s[i] >= '0') {
                num = num * 10 + (s[i] - '0');
            }
            if (s[i] < '0' && s[i] != ' ' || i == n - 1) {
                if (sign == '+') {
                    st.push(num);
                } else if (sign == '-') {
                    st.push(-num);
                } else if (sign == '*') {
                    int tmp = st.top();
                    st.pop();
                    st.push(tmp * num);
                } else if (sign == '/') {
                    int tmp = st.top();
                    st.pop();
                    st.push(tmp / num);
                }
                sign = s[i];
                num = 0;
            }
        }
        int res = 0;
        while (!st.empty()) {
            res += st.top();
            st.pop();
        }
        return res;
    }
};