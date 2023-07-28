class Solution {
public:
    string reverseParentheses(string s) {
        
        int n = s.length();
        stack<int> st;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '(') {
                st.push(i);
            } else if (s[i] == ')') {
                int l = st.top();
                st.pop();
                reverse(s.begin() + l, s.begin() + i);
            }
        }
        string ans;
        for (int i = 0; i < n; ++i) {
            if (s[i] != '(' && s[i] != ')') {
                ans.push_back(s[i]);
            }
        }
        return ans;
    }
};