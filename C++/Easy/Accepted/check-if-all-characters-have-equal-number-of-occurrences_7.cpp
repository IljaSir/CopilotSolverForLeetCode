class Solution {
public:
    bool areOccurrencesEqual(string s) {
        
        std::map<char, int> m;
        for (auto c: s) {
            m[c]++;
        }
        int first = m.begin()->second;
        for (auto it = m.begin(); it != m.end(); ++it) {
            if (it->second != first) {
                return false;
            }
        }
        return true;
    }
};