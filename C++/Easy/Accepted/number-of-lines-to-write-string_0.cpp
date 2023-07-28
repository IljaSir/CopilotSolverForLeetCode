class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
        
        int sum = 0;
        int lines = 1;
        for (int i = 0; i < s.length(); i++) {
            sum += widths[s[i] - 'a'];
            if (sum > 100) {
                lines++;
                sum = widths[s[i] - 'a'];
            }
        }
        return {lines, sum};
    }
};