class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        unordered_set<string> dict(dictionary.begin(), dictionary.end());
        istringstream ss(sentence);
        string word;
        string result;
        while (ss >> word) {
            string prefix;
            for (int i = 1; i <= word.size(); i++) {
                prefix = word.substr(0, i);
                if (dict.count(prefix)) {
                    break;
                }
            }
            result += prefix + " ";
        }
        result.pop_back();
        return result;
    }
};