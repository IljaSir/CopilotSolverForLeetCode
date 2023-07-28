class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int n = s.size();
        vector<int> cnt(26, 0);
        int left = 0, right = 0;
        int maxCnt = 0;
        int maxLen = 0;
        while (right < n) {
            cnt[s[right] - 'A']++;
            maxCnt = max(maxCnt, cnt[s[right] - 'A']);
            while (right - left + 1 - maxCnt > k) {
                cnt[s[left] - 'A']--;
                left++;
            }
            maxLen = max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
};