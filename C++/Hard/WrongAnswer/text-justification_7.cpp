class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        
        vector<string> result;
        int n = words.size();
        int i = 0;
        while (i < n) {
            int j = i + 1;
            int curLen = words[i].size();
            while (j < n && curLen + words[j].size() + 1 <= maxWidth) {
                curLen += words[j].size() + 1;
                j++;
            }
            int spaceNum = maxWidth - curLen;
            int spaceSlot = j - i - 1;
            string line;
            if (j == n || spaceSlot == 0) {
                for (int k = i; k < j; k++) {
                    line += words[k];
                    if (k != j - 1) {
                        line += " ";
                    }
                }
                line += string(spaceNum - spaceSlot, ' ');
            } else {
                int spaceAvg = spaceNum / spaceSlot;
                int spaceRem = spaceNum % spaceSlot;
                for (int k = i; k < j; k++) {
                    line += words[k];
                    if (k != j - 1) {
                        line += string(spaceAvg + (k - i < spaceRem ? 1 : 0), ' ');
                    }
                }
            }
            result.push_back(line);
            i = j;
        }
        return result;
    }
};