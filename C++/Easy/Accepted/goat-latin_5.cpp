class Solution {
public:
    string toGoatLatin(string sentence) {
        
        string res;
        string word;
        string suffix = "ma";
        string a = "a";
        istringstream iss(sentence);
        while (iss >> word) {
            if (word[0] == 'a' || word[0] == 'e' || word[0] == 'i' || word[0] == 'o' || word[0] == 'u' ||
                word[0] == 'A' || word[0] == 'E' || word[0] == 'I' || word[0] == 'O' || word[0] == 'U') {
                word += suffix;
            } else {
                word = word.substr(1) + word[0] + suffix;
            }
            res += word + a + " ";
            suffix += "a";
        }
        res.pop_back();
        return res;
    }
};