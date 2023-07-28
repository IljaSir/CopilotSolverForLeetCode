class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        string res;
        for (int i = 0; i < sentence.size(); ++i) {
            if (sentence[i] == ' ') {
                res += ' ';
                continue;
            }
            for (int j = i; j < sentence.size(); ++j) {
                if (sentence[j] == ' ') {
                    res += sentence.substr(i, j - i);
                    i = j - 1;
                    break;
                }
                string s = sentence.substr(i, j - i + 1);
                for (string& d : dictionary) {
                    if (s == d) {
                        res += d;
                        i = j;
                        break;
                    }
                }
            }
        }
        return res;
    }
};