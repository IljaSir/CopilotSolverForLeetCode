class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        
        int line = 1;
        int width = 0;
        for (int i = 0; i < s.size(); ++i) {
            int w = widths[s[i] - 'a'];
            if (width + w <= 100) {
                width += w;
            } else {
                ++line;
                width = w;
            }
        }
        return {line, width};
    }
};