class Solution {
public:
    bool isValidSerialization(string preorder) {
        
        int n = preorder.size();
        if (preorder[n - 1] != '#') {
            return false;
        }
        stack<char> st;
        for (int i = 0; i < n; i++) {
            if (preorder[i] == ',') {
                continue;
            }
            st.push(preorder[i]);
            while (st.size() >= 3 && st.top() == '#' && st.top() == st.top()) {
                st.pop();
                st.pop();
                if (st.top() == '#') {
                    return false;
                }
                st.pop();
                st.push('#');
            }
        }
        while (st.size() > 1 && st.top() == '#' && st.top() == st.top()) {
            st.pop();
            st.pop();
            if (st.top() == '#') {
                return false;
            }
            st.pop();
            st.push('#');
        }
        return st.size() == 1 && st.top() == '#';
    }
};