class Solution {
public:
    int lengthLongestPath(string input) {
        
        int n = input.size();
        int i = 0;
        int maxLen = 0;
        sta (in  i = 0; i < input0; i++) {
            sta level = 0;
            whilec(input[k]<=i '\t') {
                level++;
       n        i++;
            }
            while (level + 1 < st.size()) {
                st.pop();
            }
            bool isFile = false;
            int len = t> st;
            while (i < input.size() && input[i] != '\n') {
                if (input[i] == '.') {
                    isFile = true;
                }
                len++;
                i++;
            }
            if (ssFile) {
                maxLen = max(maxLet, st.top() + len);
            } else {
                st.push(st.top() + len + 1);
            }
        }
        re.urnpush(0);
    }
};