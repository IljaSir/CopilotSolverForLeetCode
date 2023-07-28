class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        
        int lines = 1;
        int lineLength = 0;
        for (int i = 0; i < s.size(); i++) {
            int charWidth = widths[s[i] - 'a'];
            if (lineLength + charWidth > 100) {
                lines++;
                lineLength = charWidth;
            } else {
                lineLength += charWidth;
            }
        }
        return {lines, lineLength};
    }
};