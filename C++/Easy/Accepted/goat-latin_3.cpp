class Solution {
public:
    string toGoatLatin(string sentence) {
        
        string res;
        string suffix = "ma";
        int count = 0;
        for (int i = 0; i < sentence.size(); i++) {
            int j = i;
            while (j < sentence.size() && sentence[j] != ' ') {
                j++;
            }
            count++;
            string word = sentence.substr(i, j - i);
            if (word[0] == 'a' || word[0] == 'e' || word[0] == 'i' || word[0] == 'o' || word[0] == 'u' ||
                word[0] == 'A' || word[0] == 'E' || word[0] == 'I' || word[0] == 'O' || word[0] == 'U') {
                res += word + suffix;
            } else {
                res += word.substr(1) + word[0] + suffix;
            }
            for (int k = 0; k < count; k++) {
                res += 'a';
            }
            res += ' ';
            i = j;
        }
        res.pop_back();
        return res;
    }
};