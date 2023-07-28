class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        
        map<string, int> m;
        vector<string> res;
        stringstream ss(s1);
        string word;
        while (ss >> word) {
            m[word]++;
        }
        ss = stringstream(s2);
        while (ss >> word) {
            m[word]++;
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second == 1) {
                res.push_back(it->first);
            }
        }
        return res;
    }
};