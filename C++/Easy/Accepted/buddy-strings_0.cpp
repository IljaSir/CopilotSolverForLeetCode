class Solution {
public:
    bool buddyStrings(string s, string goal) {
        
        if (s.size() != goal.size()) return false;
        if (s == goal) {
            int cnt[26] = {0};
            for (char c : s) cnt[c - 'a']++;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] >= 2) return true;
            }
            return false;
        }
        int idx[2] = {-1, -1};
        int num = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != goal[i]) {
                if (num == 2) return false;
                idx[num++] = i;
            }
        }
        if (num == 1) return false;
        return s[idx[0]] == goal[idx[1]] && s[idx[1]] == goal[idx[0]];
    }
};