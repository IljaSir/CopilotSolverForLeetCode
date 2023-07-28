class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        
        vector<string> res;
        unordered_map<string, int> m;
        string word;
        istringstream iss(s1 + " " + s2);
        while(iss >> word) {
            m[word]++;
        }
        for(auto& [word, count] : m) {
            if(count == 1) {
                res.push_back(word);
            }
        }
        return res;
    }
};