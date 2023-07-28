class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int len = s.length();
        if (len <= 1) {
            return 1;
        }
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            int curMax = 0;
            int curK = k;
            int j = i;
            for (; j < len; j++) {
                if (s[j] == s[i]) {
                    curMax++;
                } else {
                    if (curK > 0) {
                        curMax++;
                        curK--;
                    } else {
                        break;
                    }
                }
            }
            maxLen = max(maxLen, curMax);
        }
        return maxLen;
    }
};