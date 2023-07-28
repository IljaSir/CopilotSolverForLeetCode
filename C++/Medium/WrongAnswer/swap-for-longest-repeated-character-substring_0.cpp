class Solution {
public:
    int maxRepOpt1(string text) {
        
        int n = text.size();
        int res = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && text[j] == text[i]) ++j;
            int cnt = j - i;
            res = max(res, cnt);
            int k = j;
            while (k < n && text[k] == text[i]) ++k;
            if (k < n && text[k] == text[j]) {
                res = max(res, cnt + 1);
                while (k < n && text[k] == text[i]) ++k;
                res = max(res, k - j + 1);
            }
            i = j;
        }
        return res;
    }
};