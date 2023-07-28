class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        
        vector<string> rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        vector<string> res;
        for (string word : words) {
            int row = -1;
            for (int i = 0; i < 3; ++i) {
                if (rows[i].find(tolower(word[0])) != string::npos) {
                    row = i;
                    break;
                }
            }
            bool flag = true;
            for (char c : word) {
                if (rows[row].find(tolower(c)) == string::npos) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.push_back(word);
        }
        return res;
    }
};