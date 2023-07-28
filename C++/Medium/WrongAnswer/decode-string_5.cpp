class Solution {
public:
    string decodeString(string s) {
        
        stack<string> st;
        string res;
        for (auto c : s) {
            if (c == ']') {
                string str;
                while (st.top() != "[") {
                    str = st.top() + str;
                    st.pop();
                }
                st.pop();
                int k = stoi(st.top());
                st.pop();
                while (k--) {
                    st.push(str);
                }
            } else {
                st.push(string(1, c));
            }
        }
        while (!st.empty()) {
            res = st.top() + res;
            st.pop();
        }
        return res;
    }
};