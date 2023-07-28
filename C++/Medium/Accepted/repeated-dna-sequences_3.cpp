class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        
        unordered_map<string, int> m;
        vector<string> res;
        for (int i = 0; i + 10 <= s.size(); i++) {
            string t = s.substr(i, 10);
            if (m[t]++ == 1) res.push_back(t);
        }
        return res;
    }
};