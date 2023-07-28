class Solution {
public:
    int numDifferentIntegers(string word) {
        
        set<string> st;
        string num;
        for (char c : word) {
            if (isdigit(c)) {
                num += c;
            } else {
                if (!num.empty()) {
                    st.insert(num);
                    num.clear();
                }
            }
        }
        if (!num.empty()) {
            st.insert(num);
        }
        return st.size();
    }
};