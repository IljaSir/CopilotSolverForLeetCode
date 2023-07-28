class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int i = 0, j = 0, n = s.length(), maxCount = 0, res = 0;
        vector<int> count(26, 0);
        while (j < n) {
            maxCount = max(maxCount, ++count[s[j++] - 'A']);
            while (j - i - maxCount > k) {
                --count[s[i++] - 'A'];
            }
            res = max(res, j - i);
        }
        return res;
    }
};