class Solution {
public:
    string decodeString(string s) {
        
        string res;
        stack<char> st;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] != ']') {
                st.push(s[i]);
            } else {
                string temp;
                while (st.top() != '[') {
                    temp = st.top() + temp;
                    st.pop();
                }
                st.pop();
                int k = 0;
                int base = 1;
                while (!st.empty() && isdigit(st.top())) {
                    k += (st.top() - '0') * base;
                    base *= 10;
                    st.pop();
                }
                while (k-- > 0) {
                    for (int j = 0; j < temp.size(); ++j) {
                        st.push(temp[j]);
                    }
                }
            }
        }
        while (!st.empty()) {
            res = st.top() + res;
            st.pop();
        }
        return res;
    }
};