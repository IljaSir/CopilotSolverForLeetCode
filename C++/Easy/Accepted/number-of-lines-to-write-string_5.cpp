class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        
        int count = 0;
        int width = 0;
        for (int i = 0; i < s.size(); i++) {
            int w = widths[s[i] - 'a'];
            if (width + w > 100) {
                count++;
                width = w;
            } else {
                width += w;
            }
        }
        return {count + 1, width};
    }
};