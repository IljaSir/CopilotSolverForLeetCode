class Solution {
public:
    string toGoatLatin(string sentence) {
        
        stringstream ss(sentence);
        string word;
        string result;
        string suffix = "ma";
        string a = "a";
        int i = 0;
        while (ss >> word) {
            i++;
            suffix += a;
            if (word[0] == 'a' || word[0] == 'e' || word[0] == 'i' || word[0] == 'o' || word[0] == 'u' || word[0] == 'A' || word[0] == 'E' || word[0] == 'I' || word[0] == 'O' || word[0] == 'U') {
            result += word + suffix + " ";
        }
        else {
            word += word[0];
            result += word.substr(1, word.size()-1) + suffix + " ";
        }
    }
};