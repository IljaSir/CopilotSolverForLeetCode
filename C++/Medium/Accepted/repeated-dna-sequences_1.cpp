class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        
        unordered_set<string> seen;
        unordered_set<string> repeated;
        for (int i = 0; i + 9 < s.size(); i++) {
            string t = s.substr(i, 10);
            if (seen.count(t)) {
                repeated.insert(t);
            }
            seen.insert(t);
        }
        return vector<string>(repeated.begin(), repeated.end());
    }
};