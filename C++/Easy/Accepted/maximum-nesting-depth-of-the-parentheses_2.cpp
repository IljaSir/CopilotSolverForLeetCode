class Solution {
public:
    int maxDepth(string s) {
        
        int max = 0;
        int count = 0;
        for (char c : s) {
            if (c == '(') {
                count++;
                if (count > max) {
                    max = count;
                }
            } else if (c == ')') {
                count--;
            }
        }
        return max;
    }
};