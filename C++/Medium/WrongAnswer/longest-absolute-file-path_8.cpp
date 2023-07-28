class Solution {
public:
    int lengthLongestPath(string input) {
        
        int i = 0;
        int n = input.size();
        int depth = 0;
        int maxLen = 0;
        vector<int> len(n + 1, 0);
        while (i < n) {
            int j = i;
            while (input[j] != '\n' && j < n) j++;
            int curDepth = 0;
            while (input[i] == '\t') {
                curDepth++;
                i++;
            }
            int curLen = j - i;
            if (input[j - 1] == '.') {
                maxLen = max(maxLen, len[curDepth] + curLen);
            } else {
                len[curDepth + 1] = len[curDepth] + curLen + 1;
            }
            i = j + 1;
        }
        return maxLen;
    }
};