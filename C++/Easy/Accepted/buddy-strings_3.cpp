class Solution {
public:
    bool buddyStrings(string s, string goal) {
        
        if (s.size() != goal.size()) return false;
        if (s == goal) {
            vector<int> cnt(26, 0);
            for (auto ch : s) {
                cnt[ch - 'a']++;
                if (cnt[ch - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }
        int n = s.size();
        int first = -1;
        int second = -1;
        for (int i = 0; i < n; i++) {
            if (s[i] != goal[i]) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        if (first != -1 && second != -1) {
            swap(s[first], s[second]);
            if (s == goal) {
                return true;
            }
        }
        return false;
    }
};