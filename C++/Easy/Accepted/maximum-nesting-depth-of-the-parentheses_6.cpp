class Solution {
public:
    int maxDepth(string s) {
        
        int depth = 0;
        int maxDepth = 0;
        for (auto c: s) {
            if (c == '(') {
                depth++;
                maxDepth = max(depth, maxDepth);
            } else if (c == ')') {
                depth--;
            }
        }
        return maxDepth;
    }
};