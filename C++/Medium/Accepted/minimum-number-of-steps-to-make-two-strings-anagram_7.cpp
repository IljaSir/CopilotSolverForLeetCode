class Solution {
public:
    int minSteps(string s, string t) {
        
        int count = 0;
        int freq[26] = {0};
        for (char c : s) {
            freq[c - 'a']++;
        }
        for (char c : t) {
            if (freq[c - 'a'] > 0) {
                freq[c - 'a']--;
            } else {
                count++;
            }
        }
        return count;
    }
};