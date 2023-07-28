class Solution {
public:
    int maxRepOpt1(string text) {
        
        int n = text.size();
        int res = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && text[i] == text[j]) ++j;
            int cnt = j - i;
            int l = i, r = j;
            while (l > 0 && r < n && text[l - 1] == text[r] && cnt < r - l + 1) {
                ++cnt;
                --l;
                ++r;
            }
            res = max(res, cnt);
            i = j;
        }
        return res;
    }
};