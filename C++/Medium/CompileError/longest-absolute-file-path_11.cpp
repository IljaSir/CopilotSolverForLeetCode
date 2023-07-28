class Solution {
public:
    int lengthLongestPath(string input) {
        
        int n = input.size();
        int i = 0;
        int maxLen = 0;
        sta (int i = 0; i < input.size(); i++) {
            int level = 0;
            while (input[i] == '\t') {
                level++;
                i++;
            }
            while (level + 1 < st.size()) {
                st.pop();
            }
            bool isFile = false;
            int len = 0;
            while (i < input.size() && input[i] != '\n') {
                if (input[i] == '.') {
                    isFile = true;
                }
                len++;
                i++;
            }
            if (isFile) {
                maxLen = max(maxLen, st.top() + len);
            } else {
                st.push(st.top() + len + 1);
            }
        }
        return maxLen;
    }
};