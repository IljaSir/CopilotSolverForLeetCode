class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        
        vector<string> v1, v2;
        split(s1, v1);
        split(s2, v2);
        map<string, int> m;
        for (auto& s: v1) {
            m[s]++;
        }
        for (auto& s: v2) {
            m[s]++;
        }
        vector<string> res;
        for (auto& p: m) {
            if (p.second == 1) {
                res.push_back(p.first);
            }
        }
        return res;
    }
    
    void split(const string& s, vector<string>& v) {
        string::size_type pos1, pos2;
        pos2 = s.find(' ');
        pos1 = 0;
        while (string::npos != pos2) {
            v.push_back(s.substr(pos1, pos2 - pos1));
            pos1 = pos2 + 1;
            pos2 = s.find(' ', pos1);
        }
        if (pos1 != s.length()) {
            v.push_back(s.substr(pos1));
        }
    }
};