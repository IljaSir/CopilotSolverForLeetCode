class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        
        vector<string> rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        vector<string> result;
        for (auto word : words) {
            int row = 0;
            while (row < rows.size()) {
                if (rows[row].find(tolower(word[0])) != string::npos) {
                    break;
                }
                row++;
            }
            bool isOneRow = true;
            for (int i = 1; i < word.size(); i++) {
                if (rows[row].find(tolower(word[i])) == string::npos) {
                    isOneRow = false;
                    break;
                }
            }
            if (isOneRow) {
                result.push_back(word);
            }
        }
        return result;
    }
};