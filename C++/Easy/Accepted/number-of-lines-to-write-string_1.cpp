class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        
        int lines = 1;
        int width = 0;
        for (auto c : s) {
            int w = widths[c - 'a'];
            if (width + w > 100) {
                lines++;
                width = w;
            } else {
                width += w;
            }
        }
        return {lines, width};
    }
};