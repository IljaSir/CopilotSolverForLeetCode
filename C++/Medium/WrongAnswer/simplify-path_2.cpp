class Solution {
public:
    string simplifyPath(string path) {
        
        stack<string> st;
        string res;
        for (int i = 0; i < path.size(); i++) {
            if (path[i] == '/') {
                continue;
            } else if (path[i] == '.') {
                if (i + 1 < path.size() && path[i + 1] == '.') {
                    if (!st.empty()) {
                        st.pop();
                    }
                    i++;
                }
            } else {
                string cur;
                while (i < path.size() && path[i] != '/') {
                    cur += path[i];
                    i++;
                }
                st.push(cur);
                i--;
            }
        }
        if (st.empty()) {
            return "/";
        }
        while (!st.empty()) {
            res = "/" + st.top() + res;
            st.pop();
        }
        return res;
    }
};