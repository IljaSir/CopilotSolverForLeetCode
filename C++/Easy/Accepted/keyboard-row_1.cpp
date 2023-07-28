class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        
        vector<string> res;
        string row1 = "qwertyuiopQWERTYUIOP";
        string row2 = "asdfghjklASDFGHJKL";
        string row3 = "zxcvbnmZXCVBNM";
        for (auto word: words) {
            int row = 0;
            for (auto c: word) {
                if (row1.find(c) != string::npos) {
                    if (row == 0) {
                        row = 1;
                    } else if (row != 1) {
                        row = -1;
                        break;
                    }
                } else if (row2.find(c) != string::npos) {
                    if (row == 0) {
                        row = 2;
                    } else if (row != 2) {
                        row = -1;
                        break;
                    }
                } else if (row3.find(c) != string::npos) {
                    if (row == 0) {
                        row = 3;
                    } else if (row != 3) {
                        row = -1;
                        break;
                    }
                }
            }
            if (row != -1) {
                res.push_back(word);
            }
        }
        return res;
    }
};