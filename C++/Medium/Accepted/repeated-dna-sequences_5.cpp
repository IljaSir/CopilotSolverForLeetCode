class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        
        vector<string> res;
        unordered_map<string, int> map;
        for (int i = 0; i + 9 < s.size(); i++) {
            string str = s.substr(i, 10);
            map[str]++;
            if (map[str] == 2) {
                res.push_back(str);
            }
        }
        return res;
    }
};