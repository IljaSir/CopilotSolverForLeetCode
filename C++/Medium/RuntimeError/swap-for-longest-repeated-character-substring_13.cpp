class Solution {
public:
    int maxRepOpt1(string text) {
        
        vector<int> v(26, 0);
        for (char c : text) {
            ++v[c - 'a'];
        }
        int n = text.size();
        int i = 0, j = 0;
        int res = 0;
        while (i < n) {
            int c = text[i] - 'a';
            int k = 1;
            while (i + k < n && text[i + k] == text[i]) {
                ++k;
            }
            if (k < v[c]) {
                int l = i + k;
                while (l < n && text[l] == text[i]) {
                    ++l;
                }
                if (l < n && text[l] == text[i - 1]) {
                    res = max(res, l - i + 1);
                } else {
                    res = max(res, l - i);
                }
            }
            res = max(res, k);
            i += k;
        }
        return res;
    }
};