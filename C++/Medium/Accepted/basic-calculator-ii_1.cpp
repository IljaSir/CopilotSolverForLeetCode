class Solution {
public:
    int calculate(string s) {
        
        stack<int> st;
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.size(); ++i) {
            if (isdigit(s[i])) {
                num = num * 10 + (s[i] - '0');
            }
            if (!isdigit(s[i]) && !isspace(s[i]) || i == s.size() - 1) {
                if (sign == '+') st.push(num);
                if (sign == '-') st.push(-num);
                if (sign == '*' || sign == '/') {
                    int tmp = sign == '*' ? st.top() * num : st.top() / num;
                    st.pop();
                    st.push(tmp);
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