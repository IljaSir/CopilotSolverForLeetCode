class Solution {
public:
    int lengthLongestPath(string input) {
        
        int maxLen = 0;
        int curLen = 0;
        int curDepth = 0;
        int curLevel = 0;
        int curLevelLen = 0;
        int curLevelStart = 0;
        int curLevelEnd = 0;
        int curLevelFile = 0;
        int curLevelFileLen = 0;
        int curLevelFileStart = 0;
        int curLevelFileEnd = 0;
        int curLevelDir = 0;
        int curLevelDirLen = 0;
        int curLevelDirStart = 0;
        int curLevelDirEnd = 0;
        int curLevelTab = 0;
        int curLevelTabLen = 0;
        int curLevelTabStart = 0;
        int curLevelTabEnd = 0;
        int curLevelSpace = 0;
        int curLevelSpaceLen = 0;
        int curLevelSpaceStart = 0;
        int curLevelSpaceEnd = 0;
        int curLevelDot = 0;
        int curLevelDotLen = 0;
        int curLevelDotStart = 0;
        int curLevelDotEnd = 0;
        int curLevelOther = 0;
        int curLevelOtherLen = 0;
        int curLevelOtherStart = 0;
        int curLevelOtherEnd = 0;
        int curLevelChar = 0;
        int curLevelCharLen = 0;
        int curLevelCharStart = 0;
        int curLevelCharEnd = 0;
        int curLevelNewLine = 0;
        int curLevelNewLineLen = 0;
        int curLevelNewLineStart = 0;
        int curLevelNewLineEnd = 0;
        int curLevelBackSlash = 0;
        int curLevelBackSlashLen = 0;
        int curLevelBackSlashStart = 0;
        int curLevelBackSlashEnd = 0;
        int curLevelSlash = 0;
        int curLevelSlashLen = 0;
        int curLevelSlashStart = 0;
        int curLevelSlashEnd = 0;
        int curLevelTabCount = 0;
        int curLevelTabCountStart = 0;
        int curLevelTabCountEnd = 0;
        int curLevelTabCountLen = 0;
        int level = 0;
        int len = 0;
        int n = input.size();
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            if (input[i] == '\n') {
                len = 0;
                level = 0;
            } else if (input[i] == '\t') {
                level++;
            } else if (input[i] == '.') {
                res = max(res, m[level] + len + 1);
            } else {
                len++;
                m[level + 1] = m[level] + len + 1;
            }
        }
        return res;
    }
};