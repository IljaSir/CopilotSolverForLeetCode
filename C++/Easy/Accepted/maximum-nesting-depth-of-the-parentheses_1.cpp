class Solution {
public:
    int maxDepth(string s) {
        
        int maxDepth = 0;
        int curDepth = 0;
        for (char c : s) {
            if (c == '(') {
                curDepth++;
                maxDepth = max(maxDepth, curDepth);
            } else if (c == ')') {
                curDepth--;
            }
        }
        return maxDepth;
    }
};