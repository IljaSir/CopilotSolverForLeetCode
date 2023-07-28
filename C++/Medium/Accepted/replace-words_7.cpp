class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        std::sort(dictionary.begin(), dictionary.end(), [](const string& a, const string& b) {return a.length() < b.length();});
        std::istringstream iss(sentence);
        std::string word;
        std::string result;
        while (iss >> word) {
            for (const auto& root : dictionary) {
                if (word.compare(0, root.length(), root) == 0) {
                    word = root;
                    break;
                }
            }
            if (!result.empty()) {
                result += " ";
            }
            result += word;
        }
        return result;
    }
};