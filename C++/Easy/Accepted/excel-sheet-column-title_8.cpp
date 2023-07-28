class Solution {
public:
    string convertToTitle(int columnNumber) {
        
        string result;
        while(columnNumber > 0) {
            int x = (columnNumber - 1) % 26;
            result = char('A' + x) + result;
            columnNumber = (columnNumber - x) / 26;
        }
        return result;
    }
};