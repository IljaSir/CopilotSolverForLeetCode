class Solution {
public:
    long long appealSum(string s) {
        
        int len = s.length();
        long long res = 0;
        for (int i = 0; i < len; ++i) {
            set<char> st;
            for (int j = i; j < len; ++j) {
                st.insert(s[j]);
                res += st.size();
            }
        }
        return res;
    }
};