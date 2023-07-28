class Solution {
public:
    int maxRepOpt1(string text) {
        
        int n = text.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && text[j] == text[i]) j++;
            int cnt1 = j - i;
            int cnt2 = 0;
            if (j < n && text[j] != text[i]) {
                int k = j;
                while (k < n && text[k] == text[j]) k++;
                cnt2 = k - j;
            }
            ans = max(ans, min(cnt1 + cnt2 + 1, n));
            i = j;
        }
        return ans;
    }
};