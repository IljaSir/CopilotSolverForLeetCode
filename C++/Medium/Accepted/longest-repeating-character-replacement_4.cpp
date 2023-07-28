class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int left = 0, right = 0, maxCount = 0, maxLen = 0;
        vector<int> count(26, 0);
        while (right < s.size()) {
            maxCount = max(maxCount, ++count[s[right] - 'A']);
            while (right - left + 1 - maxCount > k) {
                count[s[left++] - 'A']--;
            }
            maxLen = max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
};