class Solution {
public:
    string reorganizeString(string s) {
        
        int n = s.size();
        vector<int> cnt(26);
        for (auto c : s) {
            ++cnt[c - 'a'];
        }
        int maxCnt = 0;
        for (int i = 0; i < 26; ++i) {
            maxCnt = max(maxCnt, cnt[i]);
        }
        if (maxCnt > (n + 1) / 2) {
            return "";
        }
        int evenIdx = 0, oddIdx = 1;
        int halfSize = n / 2;
        vector<char> ans(n);
        for (int i = 0; i < 26; ++i) {
            char c = i + 'a';
            while (cnt[i] > 0 && cnt[i] <= halfSize && oddIdx < n) {
                ans[oddIdx] = c;
                oddIdx += 2;
                --cnt[i];
            }
            while (cnt[i] > 0) {
                ans[evenIdx] = c;
                evenIdx += 2;
                --cnt[i];
            }
        }
        return string(ans.begin(), ans.end());
    }
};