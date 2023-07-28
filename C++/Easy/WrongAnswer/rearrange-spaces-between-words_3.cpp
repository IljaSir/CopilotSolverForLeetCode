class Solution {
public:
    string reorderSpaces(string text) {
        
        int n = text.size();
        int space = 0;
        vector<string> words;
        for (int i = 0; i < n; i++) {
            if (text[i] == ' ') {
                space++;
            } else {
                int j = i;
                while (j < n && text[j] != ' ') {
                    j++;
                }
                words.push_back(text.substr(i, j-i));
                i = j;
            }
        }
        int m = words.size();
        if (m == 1) {
            string res = words[0];
            for (int i = 0; i < space; i++) {
                res += ' ';
            }
            return res;
        }
        int gap = space / (m-1);
        int remain = space % (m-1);
        string res = words[0];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < gap; j++) {
                res += ' ';
            }
            res += words[i];
        }
        for (int i = 0; i < remain; i++) {
            res += ' ';
        }
        return res;
    }
};