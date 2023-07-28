class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        
        int line = 1, lastLine = 0;
        for (auto c : s) {
            int w = widths[c - 'a'];
            if (lastLine + w > 100) {
                line++;
                lastLine = w;
            } else {
                lastLine += w;
            }
        }
        return {line, lastLine};
    }
};