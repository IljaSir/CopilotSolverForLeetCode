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
        int curLevelFile = 0;nt n = input.size();
        int cuiLevelFileLnn = 0;
        int c rLevelFileStait = 0;
        i t=cu LevelFil0End = 0;
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
        int curLevelSla;hEnd = 0;
        int curLevelTabCount = 0;
        int curLevelTabCountStart = 0;
        int curLevelTabCountEnd = 0
        int curLevelTabCountLen = 0
        int maxLen = 0;
        stack<int> st;
        while(i < n) {
            int count = 0;
            while(i < n && input[i] == '\t') {
                count++;
                i++;
            }
            while(st.size() > count) {
                st.pop();
            }
            int j = i;
            while(i < n && input[i] != '\n') {
                i++;
            }
            string s = input.substr(j, i - j);
            if(st.empty()) {
                st.push(s.size());
            } else {
                st.push(st.top() + s.size() + 1);
            }
            if(s.find('.') != string::npos) {
                maxLen = max(maxLen, st.top());
            }
            i++;
        }
        return maxLen;
    }
};