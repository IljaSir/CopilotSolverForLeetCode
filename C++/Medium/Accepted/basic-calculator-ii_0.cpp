class Solution {
public:
    int calculate(string s) {
        
        stack<int> st;
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.size(); i++) {
            if (isdigit(s[i])) {
                num = num * 10 + (s[i] - '0');
            }
            if ((!isdigit(s[i]) && !isspace(s[i])) || i == s.size() - 1) {
                if (op == '+') {
                    st.push(num);
                } else if (op == '-') {
                    st.push(-num);
                } else if (op == '*') {
                    int temp = st.top(); st.pop();
                    st.push(temp * num);
                } else if (op == '/') {
                    int temp = st.top(); st.pop();
                    st.push(temp / num);
                }
                op = s[i];
                num = 0;
            }
        }
        int res = 0;
        while (!st.empty()) {
            res += st.top(); st.pop();
        }
        return res;
    }
};