class Solution {
public:
    int maxRepOpt1(string text) {
        
        int n = text.size();
        vector<int> count(26, 0);
        for (int i = 0; i < n; i++) {
            count[text[i] - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = max(res, count[i]);
        }
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && text[j] == text[i]) {
                j++;
            }
            int k = j;
            while (k < n && text[k] != text[i]) {
                k++;
            }
            if (k < n) {
                int l = k;
                while (l < n && text[l] == text[k]) {
                    l++;
                }
                res = max(res, j - i + l - k);
            }
            i = j;
        }
        return res;
    }
};