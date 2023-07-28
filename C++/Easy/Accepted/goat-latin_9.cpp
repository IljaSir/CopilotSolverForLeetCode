class Solution {
public:
    string toGoatLatin(string sentence) {
        
        string result = "";
        int i = 0;
        int j = 0;
        int word = 0;
        bool isVowel = false;
        while (i < sentence.size()) {
            j = i;
            while (j < sentence.size() && sentence[j] != ' ') {
                j++;
            }
            word++;
            if (sentence[i] == 'a' || sentence[i] == 'e' || sentence[i] == 'i' || sentence[i] == 'o' || sentence[i] == 'u' ||
                sentence[i] == 'A' || sentence[i] == 'E' || sentence[i] == 'I' || sentence[i] == 'O' || sentence[i] == 'U') {
                isVowel = true;
            } else {
                isVowel = false;
            }
            if (isVowel) {
                result += sentence.substr(i, j - i);
                result += "ma";
            } else {
                result += sentence.substr(i + 1, j - i - 1);
                result += sentence[i];
                result += "ma";
            }
            for (int k = 0; k < word; k++) {
                result += "a";
            }
            if (j < sentence.size()) {
                result += " ";
            }
            i = j + 1;
        }
        return result;
    }
};