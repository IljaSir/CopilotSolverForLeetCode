class Solution {
public:
    bool isValid(string s) {
        
        int n = s.size();
        if (n % 3 != 0) return false;
        stack<char> st;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'c') {
                if (st.empty() || st.top() != 'b') return false;
                st.pop();
                if (st.empty() || st.top() != 'a') return false;
                st.pop();
            } else {
                st.push(s[i]);
            }
        }
        return st.empty();
    }
};