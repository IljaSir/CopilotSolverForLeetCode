class Solution {
public:
    int numDifferentIntegers(string word) {
        
        int len = word.length();
        unordered_set<string> st;
        string tmp = "";
        for (int i = 0; i < len; i++) {
            if (isdigit(word[i])) {
                tmp += word[i];
            } else {
                if (tmp.length() > 0) {
                    st.insert(tmp);
                    tmp = "";
                }
            }
        }
        if (tmp.length() > 0) {
            st.insert(tmp);
        }
        return st.size();
    }
};