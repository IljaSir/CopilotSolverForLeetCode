class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        
        vector<string> result;
        if (words.size() == 0) return result;
        string row1 = "qwertyuiop";
        string row2 = "asdfghjkl";
        string row3 = "zxcvbnm";
        for (auto word: words) {
            string temp = word;
            transform(temp.begin(), temp.end(), temp.begin(), ::tolower);
            int row = 0;
            if (row1.find(temp[0]) != string::npos) row = 1;
            else if (row2.find(temp[0]) != string::npos) row = 2;
            else row = 3;
            bool flag = true;
            for (int i = 1; i < temp.size(); i++) {
                if (row == 1 && row1.find(temp[i]) == string::npos) {
                    flag = false;
                    break;
                } else if (row == 2 && row2.find(temp[i]) == string::npos) {
                    flag = false;
                    break;
                } else if (row == 3 && row3.find(temp[i]) == string::npos) {
                    flag = false;
                    break;
                }
            }
            if (flag) result.push_back(word);
        }
        return result;
    }
};