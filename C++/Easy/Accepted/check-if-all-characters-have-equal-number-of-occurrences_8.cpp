class Solution {
public:
    bool areOccurrencesEqual(string s) {
        
        unordered_map<char, int> m;
        for (char c : s) {
            m[c]++;
        }
        int cnt = m[s[0]];
        for (auto& [c, val] : m) {
            if (val != cnt) {
                return false;
            }
        }
        return true;
    }
};