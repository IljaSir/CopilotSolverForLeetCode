class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {
        
        int res = 0;
        unordered_map<string, int> m;
        for (int i = 0; i + minSize <= s.size(); ++i) {
            string t = s.substr(i, minSize);
            unordered_set<char> st(t.begin(), t.end());
            if (st.size() <= maxLetters) {
                ++m[t];
                res = max(res, m[t]);
            }
        }
        return res;
    }
};