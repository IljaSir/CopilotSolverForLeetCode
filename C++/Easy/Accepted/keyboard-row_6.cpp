class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        
        vector<string> res;
        vector<string> keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (string word : words) {
            int row = -1;
            bool ok = true;
            for (int i = 0; i < word.size(); i++) {
                if (i == 0) {
                    if (keyboard[0].find(tolower(word[i])) != string::npos) {
                        row = 0;
                    } else if (keyboard[1].find(tolower(word[i])) != string::npos) {
                        row = 1;
                    } else {
                        row = 2;
                    }
                } else {
                    if (keyboard[row].find(tolower(word[i])) == string::npos) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                res.push_back(word);
            }
        }
        return res;
    }
};