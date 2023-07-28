class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {
        
        if (s.empty()) return 0;
        if (maxSize > s.size()) maxSize = s.size();
        if (minSize > maxSize) return 0;
        unordered_map<string, int> m;
        for (int i = 0; i <= s.size() - minSize; ++i) {
            string sub = s.substr(i, minSize);
            unordered_set<char> st(sub.begin(), sub.end());
            if (st.size() > maxLetters) continue;
            m[sub]++;
        }
        int res = 0;
        for (auto& [k, v]: m) {
            res = max(res, v);
        }
        return res;
    }
};