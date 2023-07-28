class Solution {
public:
    int maxFreq(string s, int maxLetters, int minSize, int maxSize) {
        
        int n = s.size();
        int res = 0;
        unordered_map<string, int> m;
        for (int i = 0; i < n; ++i) {
            unordered_set<char> c;
            for (int j = i; j < n && j < i + maxSize; ++j) {
                c.insert(s[j]);
                if (c.size() > maxLetters) break;
                if (j - i + 1 >= minSize) {
                    ++m[s.substr(i, j - i + 1)];
                    res = max(res, m[s.substr(i, j - i + 1)]);
                }
            }
        }
        return res;
    }
};