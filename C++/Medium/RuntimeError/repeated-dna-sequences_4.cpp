class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        
        vector<string> res;
        unordered_map<string, int> m;
        for (int i = 0; i <= s.length() - 10; ++i) {
            string str = s.substr(i, 10);
            if (++m[str] == 2) {
                res.push_back(str);
            }
        }
        return res;
    }
};