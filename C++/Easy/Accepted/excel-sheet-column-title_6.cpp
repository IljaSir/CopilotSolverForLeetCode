class Solution {
public:
    string convertToTitle(int columnNumber) {
        
        string res = "";
        while (columnNumber) {
            int digit = (columnNumber - 1) % 26;
            res = (char)('A' + digit) + res;
            columnNumber = (columnNumber - 1) / 26;
        }
        return res;
    }
};