class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        
        int len = s.length();
        if (len <= 10) return {};
        vector<string> res;
        unordered_map<string, int> mp;
        for (int i = 0; i <= len - 10; i++) {
            string sub = s.substr(i, 10);
            if (++mp[sub] == 2) res.push_back(sub);
        }
        return res;
    }
};