class Solution {
public:
    string toGoatLatin(string sentence) {
        
        string res;
        string suffix = "ma";
        int count = 1;
        int pos = 0;
        while (pos < sentence.size()) {
            int start = pos;
            while (pos < sentence.size() && sentence[pos] != ' ') {
                pos++;
            }
            string word = sentence.substr(start, pos - start);
            if (word[0] == 'a' || word[0] == 'e' || word[0] == 'i' || word[0] == 'o' || word[0] == 'u' ||
                word[0] == 'A' || word[0] == 'E' || word[0] == 'I' || word[0] == 'O' || word[0] == 'U') {
                res += word;
            } else {
                res += word.substr(1);
                res += word[0];
            }
            res += suffix;
            suffix += "a";
            res += " ";
            pos++;
        }
        res.pop_back();
        return res;
    }
};