class Solution {
public:
    string toGoatLatin(string sentence) {
        
        stringstream ss(sentence);
        string word;
        string result;
        int count = 0;
        while (ss >> word) {
            if (count > 0) {
                result += " ";
            }
            count++;
            if (word.length() == 0) {
                continue;
            }
            if (word[0] == 'a' || word[0] == 'e' || word[0] == 'i' || word[0] == 'o' || word[0] == 'u' ||
                word[0] == 'A' || word[0] == 'E' || word[0] == 'I' || word[0] == 'O' || word[0] == 'U') {
                result += word;
            } else {
                result += word.substr(1);
                result += word[0];
            }
            result += "ma";
            for (int i = 0; i < count; i++) {
                result += "a";
            }
        }
        return result;
    }
};