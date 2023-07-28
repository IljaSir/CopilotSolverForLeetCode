class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        
        vector<string> res;
        vector<string> keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (auto word : words) {
            int row = 0;
            for (int i = 0; i < 3; i++) {
                if (keyboard[i].find(tolower(word[0])) != string::npos) {
                    row = i;
                    break;
                }
            }
            bool flag = true;
            for (auto c : word) {
                if (keyboard[row].find(tolower(c)) == string::npos) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.push_back(word);
        }
        return res;
    }
};