class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        
        map<string, int> map;
        vector<string> res;
        istringstream iss(s1);
        string word;
        while(iss >> word) {
            map[word]++;
        }
        iss.str(s2);
        while(iss >> word) {
            map[word]++;
        }
        for(auto& it: map) {
            if(it.second == 1) {
                res.push_back(it.first);
            }
        }
        return res;
    }
};