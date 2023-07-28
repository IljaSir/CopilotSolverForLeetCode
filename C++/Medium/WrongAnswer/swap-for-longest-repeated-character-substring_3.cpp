class Solution {
public:
    int maxRepOpt1(string text) {
        
        int n = text.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && text[j] == text[i]) {
                j++;
            }
            int k = j;
            while (k < n && text[k] != text[i]) {
                k++;
            }
            int l = k;
            while (l < n && text[l] == text[i]) {
                l++;
            }
            ans = max(ans, min(j - i + 1 + (k - j), l - k + j - i));
            i = j - 1;
        }
        return ans;
    }
};