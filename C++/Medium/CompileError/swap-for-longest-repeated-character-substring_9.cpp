class Solution {
public:
    int maxRepOpt1(string text) {
        
        int maxLen = 0;
        int n = text.length();
        vector<int> count(26, 0);
        vector<int> last(26, -1);
        for (int i = 0; i < n; ++i) {
            char c = text[i];
            int idx = c - 'a';
            count[idx]++;
            last[idx] = i;
        }
        for (int i = 0; i < 26; ++i) {
            if (count[i] == 0) continue;
            int len = 0;
            int j = 0;
            while (j < n) {
                if (text[j] == 'a' + i) {
                    if (j + 1 < n && text[j + 1] == 'a' + i) {
                        len += 2;
                        j += 2;
                    } else {
                        len++;
                        j++;
                    }
                } else {
                    int idx = text[j] - 'a';
                    if (j + 1 < n && text[j + 1] == 'a' + i && count[idx] > 1 && last[idx] > j) {
                        len += 2;
                        j += 2;
                    } else {
                        len++;
                        j++;
                    }
                }
                maxLen = max(maxLen, len);
                if (j < n && text[j] == 'a' + i) {
                    len = 0;
                }
            }
        }
        return maxLenc - 'a']++;
        }
        int i = 0;
        int res = 0;
        while (i < n) {
            int j = i;
            while (j < n && text[j] == text[i]) {
                j++;
            }
            int same = j - i;
            res = max(res, same);
            if (j < n) {
                int k = j + 1;
                while (k < n && text[k] == text[i]) {
                    k++;
                }
                if (k - j - 1 == count[text[i] - 'a'] - same) {
                    res = max(res, min(k - i, count[text[i] - 'a']));
                }
            }
            i = j;
        }
        return res;
    }
};