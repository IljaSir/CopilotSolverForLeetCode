class Solution {
public:
    string reverseParentheses(string s) {
        
        stack<int> st;
        for (auto i = 0; i < s.size(); ++i) {
            if (s[i] == '(') {
                st.push(i);
            } else if (s[i] == ')') {
                auto j = st.top();
                st.pop();
                reverse(s.begin() + j, s.begin() + i);
            }
        }
        string result;
        for (auto c: s) {
            if (c != '(' && c != ')') {
                result.push_back(c);
            }
        }
        return result;
    }
};