class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        sort(dictionary.begin(), dictionary.end());
        string result;
        istringstream in(sentence);
        string word;
        while (in >> word) {
            if (!result.empty()) {
                result += " ";
            }
            for (auto& root : dictionary) {
                if (word.substr(0, root.size()) == root) {
                    word = root;
                    break;
                }
            }
            result += word;
        }
        return result;
    }
};