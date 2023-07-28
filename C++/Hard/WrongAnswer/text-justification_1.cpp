class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        
        vector<string> ans;
        int n = words.size();
        int i = 0;
        while (i < n) {
            int j = i;
            int len = 0;
            while (j < n && len + words[j].size() + j - i <= maxWidth) {
                len += words[j].size();
                ++j;
            }
            int spaceNum = maxWidth - len;
            string cur;
            if (j == n) {
                for (int k = i; k < j; ++k) {
                    cur += words[k];
                    if (k != j - 1) {
                        cur += " ";
                        --spaceNum;
                    }
                }
                while (spaceNum > 0) {
                    cur += " ";
                    --spaceNum;
                }
            } else {
                int spaceNumEach = 0;
                int spaceNumExtra = 0;
                if (j - i - 1 > 0) {
                    spaceNumEach = spaceNum / (j - i - 1);
                    spaceNumExtra = spaceNum % (j - i - 1);
                }
                for (int k = i; k < j; ++k) {
                    cur += words[k];
                    if (k != j - 1) {
                        for (int m = 0; m < spaceNumEach; ++m) {
                            cur += " ";
                        }
                        if (spaceNumExtra > 0) {
                            cur += " ";
                            --spaceNumExtra;
                        }
                    }
                }
            }
            ans.push_back(cur);
            i = j;
        }
        return ans;
    }
};