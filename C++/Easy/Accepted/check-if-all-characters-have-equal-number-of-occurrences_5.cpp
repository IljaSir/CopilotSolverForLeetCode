class Solution {
public:
    bool areOccurrencesEqual(string s) {
        
        unordered_map<char, int> m;
        for (auto c : s) {
            m[c]++;
        }
        int count = m[s[0]];
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second != count) {
                return false;
            }
        }
        return true;
    }
};