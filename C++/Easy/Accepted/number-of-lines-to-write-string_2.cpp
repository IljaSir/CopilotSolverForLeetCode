class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        
        int line = 1;
        int width = 0;
        for (int i = 0; i < s.length(); i++) {
            int w = widths[s[i] - 'a'];
            if (width + w > 100) {
                line++;
                width = 0;
            }
            width += w;
        }
        return {line, width};
    }
};