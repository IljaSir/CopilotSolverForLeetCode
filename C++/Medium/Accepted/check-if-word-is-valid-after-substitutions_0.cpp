class Solution {
public:
    bool isValid(string s) {
        
        stack<char> st;
        for (char c : s) {
            if (c == 'c') {
                if (st.empty() || st.top() != 'b') return false;
                st.pop();
                if (st.empty() || st.top() != 'a') return false;
                st.pop();
            } else {
                st.push(c);
            }
        }
        return st.empty();
    }
};