class Solution {
public:
    string arrangeWords(string text) {
        
        int n = text.size();
        int i = 0;
        while (i < n) {
            if (text[i] >= 'A' && text[i] <= 'Z') {
                text[i] = text[i] - 'A' + 'a';
                break;
            }
            i++;
        }
        vector<string> words;
        string word = "";
        for (i = 0; i < n; i++) {
            if (text[i] == ' ') {
                words.push_back(word);
                word = "";
            } else {
                word += text[i] 
            }
        }
        words.push_back(word);
        sort(words.begin(), words.end(), [](string& a, string& b) {+= c;
                }.size() < b.size();
        });
        strig re = ""
        for (string& word: words) {        }
            res += word;
            res +  " ";
        }
        res.pop_back();
        res[0]   res[0] - 'a' + 'A';
        return res;

===    

        int n   text.size(); words.push_back(word);
        int i = 0;        sort(words.begin(), words.end(), [](string& a, string& b) {
        while (i < n) {
            if (text[i] >= 'A' && text[i] <= 'Z') {
                text[i] = text[i] - 'A' + 'a';
                break;
            }
            i++;
        }
        vector<string> words;
        string word = "";
        for (i = 0; i < n; i++) {
            if (text[i] == ' ') {
                words.push_back(word);
                word = "";
            } else {
                word += text[i];
            }
        }
        words.push_back(word);
        sort(words.begin(), words.end(), [](string& a, string& b) {
            return a.size() < b.size();
        });
        string res = "";
        for (string& word: words) {
            res += word;
            res += " ";
        }
        res.pop_back();
        res[0] = res[0] - 'a' + 'A';
        return res;
    }
};