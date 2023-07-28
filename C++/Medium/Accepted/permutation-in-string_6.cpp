class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        
        if (s1.size() > s2.size()) return false;
        vector<int> cnt(26, 0);
        for (char c : s1) {
            cnt[c - 'a']++;
        }
        int left = 0, right = 0;
        int diff = s1.size();
        while (right < s2.size()) {
            if (cnt[s2[right] - 'a'] > 0) {
                diff--;
            }
            cnt[s2[right] - 'a']--;
            right++;
            if (diff == 0) return true;
            if (right - left == s1.size()) {
                if (cnt[s2[left] - 'a'] >= 0) {
                    diff++;
                }
                cnt[s2[left] - 'a']++;
                left++;
            }
        }
        return false;
    }
};