class Solution {
public:
    bool isValid(string s) {
        
        stack<char> st;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == 'c') {
                if (st.size() < 2) return false;
                char a = st.top();
                st.pop();
                char b = st.top();
                st.pop();
                if (a == 'b' && b == 'a') {
                    continue;
                } else {
                    return false;
                }
            } else {
                st.push(s[i]);
            }
        }
        return st.empty();
    }
};