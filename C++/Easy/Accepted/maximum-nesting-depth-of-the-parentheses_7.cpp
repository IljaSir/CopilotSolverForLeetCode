class Solution {
public:
    int maxDepth(string s) {
        
        int maxNesting = 0;
        int curNesting = 0;
        for (char c : s) {
            if (c == '(') {
                ++curNesting;
                maxNesting = max(maxNesting, curNesting);
            } else if (c == ')') {
                --curNesting;
            }
        }
        return maxNesting;
    }
};