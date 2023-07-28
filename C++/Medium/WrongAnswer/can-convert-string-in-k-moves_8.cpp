class Solution {
public:
    bool canConvertString(string s, string t, int k) {
        
        if(s.length() != t.length()) return false;
        int times[26] = {0};
        for(int i = 0; i < s.length(); i++) {
            if(s[i] == t[i]) continue;
            int diff = t[i] - s[i];
            if(diff < 0) diff += 26;
            times[diff]++;
        }
        for(int i = 1; i < 26; i++) {
            if(times[i] == 0) continue;
            if(times[i] * 26 - i > k) return false;
        }
        return true;
    }
};