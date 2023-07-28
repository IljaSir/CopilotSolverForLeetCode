class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        set<string> dict;
        for (auto& word : dictionary) {
            dict.insert(word);
        }
        string res;
        string word;
        stringstream ss(sentence);
        while (ss >> word) {
            string prefix;
            for (int i = 1; i <= word.size(); ++i) {
                prefix = word.substr(0, i);
                if (dict.count(prefix)) {
                    break;
                }
            }
            res += prefix + " ";
        }
        res.pop_back();
        return res;
    }
};