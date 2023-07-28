class Solution {
public:
    int minSteps(string s, string t) {
        
        int count[26] = {0};
        for (auto ch : s) count[ch - 'a']++;
        for (auto ch : t) count[ch - 'a']--;
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) res += count[i];
        }
        return res;
    }
};