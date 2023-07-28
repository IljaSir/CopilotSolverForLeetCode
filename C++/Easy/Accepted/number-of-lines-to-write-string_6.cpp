class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        
        int line = 1;
        int sum = 0;
        for (char c : s) {
            int w = widths[c - 'a'];
            sum += w;
            if (sum > 100) {
                line++;
                sum = w;
            }
        }
        return {line, sum};
    }
};