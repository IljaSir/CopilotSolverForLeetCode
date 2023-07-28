class Solution {
public:
    int calculate(string s) {
        
        int n = s.size();
        stack<int> st;
        int num = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            if (isdigit(s[i])) {
                num = num * 10 + s[i] - '0';
            }
            if (!isdigit(s[i]) && !isspace(s[i]) || i == n - 1) {
                if (op == '+') {
                    st.push(num);
                } else if (op == '-') {
                    st.push(-num);
                } else if (op == '*') {
                    int tmp = st.top() * num;
                    st.pop();
                    st.push(tmp);
                } else if (op == '/') {
                    int tmp = st.top() / num;
                    st.pop();
                    st.push(tmp);
                }
                op = s[i];
                num = 0;
            }
        }
        int ans = 0;
        while (!st.empty()) {
            ans += st.top();
            st.pop();
        }
        return ans;
    }
};