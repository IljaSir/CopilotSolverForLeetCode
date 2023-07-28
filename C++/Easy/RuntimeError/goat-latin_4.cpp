class Solution {
public:
    string toGoatLatin(string sentence) {
        
        string str = "";
        int cnt = 0;
        for (int i = 0; i < sentence.length(); ++i) {
            if (sentence[i] == ' ') {
                if (str[0] == 'a' || str[0] == 'e' || str[0] == 'i' || str[0] == 'o' || str[0] == 'u' || str[0] == 'A' || str[0] == 'E' || str[0] == 'I' || str[0] == 'O' || str[0] == 'U') {
                    str += "ma";
                } else {
                    char c = str[0];
                    str = str.substr(1);
                    str += c;
                    str += "ma";
                }
                cnt++;
                for (int j = 0; j < cnt; ++j) {
                    str += 'a';
                }
                sentence.replace(i - str.length() + 1, str.length(), str);
                str = "";
            } else {
                str += sentence[i];
            }
        }
        if (str[0] == 'a' || str[0] == 'e' || str[0] == 'i' || str[0] == 'o' || str[0] == 'u' || str[0] == 'A' || str[0] == 'E' || str[0] == 'I' || str[0] == 'O' || str[0] == 'U') {
                    str += "ma";
                } else {
                    char c = str[0];
                    str = str.substr(1);
                    str += c;
                    str += "ma";
                }
                cnt++;
                for (int j = 0; j < cnt; ++j) {
                    str += 'a';
                }
                sentence.replace(sentence.length() - str.length(), str.length(), str);
        return sentence;
    }
};