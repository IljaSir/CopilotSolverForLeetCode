class Solution {
public:
    int minDeletions(string s) {
        
        int n = s.length();
        int freq[26] = {0};
        int maxFreq = 0;
        for (int i = 0; i < n; i++) {
            freq[s[i] - 'a']++;
            maxFreq = max(maxFreq, freq[s[i] - 'a']);
        }
        int ans = 0;
        int count[maxFreq + 1] = {0};
        for (int i = 0; i < 26; i++) {
            count[freq[i]]++;
        }
        for (int i = maxFreq; i >= 1; i--) {
            if (count[i] > 1) {
                ans += count[i] - 1;
                count[i - 1] += count[i] - 1;
            }
        }
        return ans;
    }
};