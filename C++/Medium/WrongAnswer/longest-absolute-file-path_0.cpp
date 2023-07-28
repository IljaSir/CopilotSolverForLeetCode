class Solution {
public:
    int lengthLongestPath(string input) {
        
        int res = 0;
        stack<int> st;
        st.push(0);
        for (int i = 0; i < input.size(); i++) {
            int level = 0;
            while (input[i] == '\t') {
                level++;
                i++;
            }
            while (level + 1 < st.size()) st.pop();
            int start = i;
            while (i < input.size() && input[i] != '\n') i++;
            int len = i - start;
            if (input.find('.', start) != string::npos) {
                res = max(res, st.top() + len);
            } else {
                st.push(st.top() + len + 1);
            }
        }
        return res;
    }
};