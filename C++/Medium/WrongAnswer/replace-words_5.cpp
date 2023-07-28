class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        string result = "";
        string word = "";
        for (auto c : sentence) {
            if (c == ' ') {
                result += getRoot(dictionary, word) + " ";
                word = "";
            } else {
                word += c;
            }
        }
        result += getRoot(dictionary, word);
        return result;
    }
    
    string getRoot(vector<string>& dictionary, string word) {
        for (auto root : dictionary) {
            if (word.find(root) == 0) {
                return root;
            }
        }
        return word;
    }
};