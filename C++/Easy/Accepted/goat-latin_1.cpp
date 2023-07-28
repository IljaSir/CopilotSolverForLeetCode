class Solution {
public:
    string toGoatLatin(string sentence) {
        
        string res;
        int cnt = 1;
        for (int i = 0; i < sentence.size(); ++i) {
            int j = i;
            while (j < sentence.size() && sentence[j] != ' ') ++j;
            if (sentence[i] == 'a' || sentence[i] == 'e' || sentence[i] == 'i' || sentence[i] == 'o' || sentence[i] == 'u' || sentence[i] == 'A' || sentence[i] == 'E' || sentence[i] == 'I' || sentence[i] == 'O' || sentence[i] == 'U') {
                res += sentence.substr(i, j - i);
                res += "ma";
            } else {
                res += sentence.substr(i + 1, j - i - 1);
                res += sentence[i];
                res += "ma";
            }
            for (int k = 0; k < cnt; ++k) {
                res += "a";
            }
            ++cnt;
            i = j;
            if (i < sentence.size()) res += " ";
        }
        return res;
    }
};