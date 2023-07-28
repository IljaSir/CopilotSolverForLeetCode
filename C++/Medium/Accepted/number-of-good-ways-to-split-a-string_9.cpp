class Solution {
public:
    int numSplits(string s) {
        
        int n = s.length();
        vector<int> left(n, 0), right(n, 0);
        int cnt = 0;
        unordered_set<char> st;
        for (int i = 0; i < n; ++i) {
            if (st.count(s[i]) == 0) {
                st.insert(s[i]);
                cnt++;
            }
            left[i] = cnt;
        }
        cnt = 0;
        st.clear();
        for (int i = n - 1; i >= 0; --i) {
            if (st.count(s[i]) == 0) {
                st.insert(s[i]);
                cnt++;
            }
            right[i] = cnt;
        }
        int res = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (left[i] == right[i + 1]) {
                res++;
            }
        }
        return res;
    }
};