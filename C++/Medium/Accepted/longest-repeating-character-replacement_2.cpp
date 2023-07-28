class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int n = s.size();
        int res = 0;
        vector<int> cnt(26, 0);
        int maxCnt = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            maxCnt = max(maxCnt, ++cnt[s[right] - 'A']);
            while (right - left + 1 - maxCnt > k) {
                cnt[s[left] - 'A']--;
                left++;
            }
            res = max(res, right - left + 1);
        }
        return res;
    }
};