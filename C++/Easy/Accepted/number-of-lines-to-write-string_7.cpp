class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        
        int line = 1;
        int pixel = 0;
        for (auto c : s) {
            int w = widths[c - 'a'];
            if (pixel + w > 100) {
                line++;
                pixel = w;
            } else {
                pixel += w;
            }
        }
        return {line, pixel};
    }
};