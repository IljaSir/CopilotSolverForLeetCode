class Solution {
public:
    string convertToTitle(int columnNumber) {
        
        string ans;
        while (columnNumber) {
            int r = columnNumber % 26;
            if (r == 0) {
                ans += 'Z';
                columnNumber = columnNumber / 26 - 1;
            } else {
                ans += (r - 1) + 'A';
                columnNumber /= 26;
            }
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};