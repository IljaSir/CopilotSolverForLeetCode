class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        
        vector<string> res;
        unordered_map<string, int> m;
        istringstream iss(s1 + " " + s2);
        string word;
        while (iss >> word) {
            m[word]++;
        }
        for (auto& [word, cnt] : m) {
            if (cnt == 1) {
                res.push_back(word);
            }
        }
        return res;
    }
};