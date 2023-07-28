class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        
        vector<int> left(26, INT_MAX), right(26, INT_MIN);
        for (int i = 0; i < s.size(); ++i) {
            int idx = s[i] - 'a';
            left[idx] = min(left[idx], i);
            right[idx] = max(right[idx], i);
        }
        vector<int> st;
        for (int i = 0; i < s.size(); ++i) {
            if (i == left[s[i] - 'a']) {
                st.push_back(i);
            } else if (i > right[s[i] - 'a']) {
                while (!st.empty() && st.back() > right[s[i] - 'a']) st.pop_back();
            }
            right[s[st.back()] - 'a'] = max(right[s[st.back()] - 'a'], right[s[i] - 'a']);
        }
        vector<string> res;
        for (int i = 0; i < st.size(); ++i) {
            res.push_back(s.substr(st[i], right[s[st[i]] - 'a'] - st[i] + 1));
        }
        return res;
    }
};