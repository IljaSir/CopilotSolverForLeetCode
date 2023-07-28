class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {
        
        unordered_map<string, int> m;
        for (int i = 0; i < s.size() - minSize + 1; i++) {
            string sub = s.substr(i, minSize);
            unordered_set<char> st;
            for (char c : sub) {
                st.insert(c);
            }
            if (st.size() <= maxLetters) {
                m[sub]++;
            }
        }
        int res = 0;
        for (auto [k, v] : m) {
            res = max(res, v);
        }
        return res;
    }
};