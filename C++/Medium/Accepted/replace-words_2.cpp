class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        string word, ret;
        stringstream ss(sentence);
        unordered_set<string> dict(dictionary.begin(), dictionary.end());
        while (ss >> word) {
            for (int i = 1; i < word.size(); ++i) {
                if (dict.find(word.substr(0, i)) != dict.end()) {
                    word = word.substr(0, i);
                    break;
                }
            }
            ret += word + " ";
        }
        ret.pop_back();
        return ret;
    }
};