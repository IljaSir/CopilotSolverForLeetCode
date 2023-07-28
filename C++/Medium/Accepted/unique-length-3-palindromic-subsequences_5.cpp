class Solution {
public:
    int countPalindromicSubsequence(string s) {
        
        int n = s.size();
        int ans = 0;
        for (char c = 'a'; c <= 'z'; ++c) {
            int i = -1, j = -1;
            for (int k = 0; k < n; ++k) {
                if (s[k] == c) {
                    if (i == -1) i = k;
                    j = k;
                }
            }
            if (i != -1) {
                set<char> st;
                for (int k = i + 1; k < j; ++k) {
                    st.insert(s[k]);
                }
                ans += st.size();
            }
        }
        return ans;
    }
};