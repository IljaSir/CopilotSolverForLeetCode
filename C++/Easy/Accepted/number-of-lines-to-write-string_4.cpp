class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        
        int line = 1;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int w = widths[s[i] - 'a'];
            if (len + w > 100) {
                line++;
                len = w;
            } else {
                len += w;
            }
        }
        return vector<int>{line, len};
    }
};