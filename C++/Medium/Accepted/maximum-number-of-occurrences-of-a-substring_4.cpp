class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {
        
        unordered_map<string, int> m;
        unordered_map<char, int> m1;
        for (int i = 0; i < minSize; ++i) {
            ++m1[s[i]];
        }
        if (m1.size() <= maxLetters) {
            ++m[s.substr(0, minSize)];
        }
        for (int i = minSize; i < s.size(); ++i) {
            --m1[s[i - minSize]];
            if (m1[s[i - minSize]] == 0) {
                m1.erase(s[i - minSize]);
            }
            ++m1[s[i]];
            if (m1.size() <= maxLetters) {
                ++m[s.substr(i - minSize + 1, minSize)];
            }
        }
        int res = 0;
        for (auto& p : m) {
            res = max(res, p.second);
        }
        return res;
    }
};