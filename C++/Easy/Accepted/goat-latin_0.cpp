class Solution {
public:
    string toGoatLatin(string sentence) {
        
        stringstream ss(sentence);
        string word;
        string res;
        int count = 1;
        while (ss >> word) {
            if (word[0] == 'a' || word[0] == 'e' || word[0] == 'i' || word[0] == 'o' || word[0] == 'u' ||
                word[0] == 'A' || word[0] == 'E' || word[0] == 'I' || word[0] == 'O' || word[0] == 'U') {
                word += "ma";
            } else {
                word = word.substr(1) + word[0] + "ma";
            }
            word += string(count, 'a');
            res += word + " ";
            count += 1;
        }
        res.pop_back();
        return res;
    }
};