class Solution {
public:
    string convertToTitle(int columnNumber) {
        
        string res;
        while (columnNumber > 0) {
            int mod = columnNumber % 26;
            if (mod == 0) {
                mod = 26;
            }
            res = char('A' + mod - 1) + res;
            columnNumber = (columnNumber - mod) / 26;
        }
        return res;
    }
};