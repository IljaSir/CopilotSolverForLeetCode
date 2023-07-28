class Solution {
public:
    bool areOccurrencesEqual(string s) {
        
        unordered_map<char, int> m;
        for (auto c : s) {
            m[c]++;
        }
        int n = m.size();
        int count = m[s[0]];
        for (auto [c, i] : m) {
            if (i != count) {
                return false;
            }
        }
        return true;
    }
};