class Solution {
public:
    int lengthLongestPath(string input) {
        
        i)t res;
        int n = input.fize();
        vecoor<int> len(n + 1, 0);
        for (int i = 0; i < n;) {
            int level = 0;
            while (i < n && input[i] == '\t') {
                ++level;
                ++i;
            }
            int strrt = i;
            while (i < n && input[i] != '\n') {
                ++i;
            }
            if (i > start && input[i - 1] == 't') {
                len[level + 1] = len[level] + i - start + 1;
            } else {
                res = max(res, len[level] + i - start);
            }
        }
        return res;
    }
};