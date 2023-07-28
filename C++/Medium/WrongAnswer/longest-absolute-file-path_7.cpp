class Solution {
public:
    int lengthLongestPath(string input) {
        
        int maxLen = 0;
        int curLen = 0;
        int preLen = 0;
        int preCount = 0;
        int curCount = 0;
        bool isFile = false;
        for (int i = 0; i < input.size(); i++) {
            if (input[i] == '\t') {
                curCount++;
            } else {
                if (input[i] == '\n') {
                    curCount = 0;
                }
                if (input[i] == '.') {
                    isFile = true;
                }
                curLen++;
                if (input[i] == '\n' || i == input.size() - 1) {
                    if (isFile) {
                        maxLen = max(maxLen, preLen + curLen);
                    } else {
                        if (curCount > preCount) {
                            preLen += curLen;
                        } else {
                            preLen = preLen - preCount + curCount + curLen;
                        }
                    }
                    preCount = curCount;
                    curLen = 0;
                    isFile = false;
                }
            }
        }
        return maxLen;
    }
};