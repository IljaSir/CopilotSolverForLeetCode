class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        
        unordered_set<char> allowedSet(allowed.begin(), allowed.end());
        int count = 0;
        for (const auto& word: words) {
            bool consistent = true;
            for (const auto& c: word) {
                if (allowedSet.find(c) == allowedSet.end()) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) {
                ++count;
            }
        }
        return count;
    }
};