class Solution {
public:
    bool buddyStrings(string s, string goal) {
        
        int n = s.size();
        int m = goal.size();
        if (n != m) return false;
        if (n == 0 && m == 0) return false;
        if (n == 1 && m == 1) return false;
        if (s == goal) {
            vector<int> cnt(26, 0);
            for (auto c : s) {
                cnt[c - 'a']++;
                if (cnt[c - 'a'] > 1) return true;
            }
            return false;
        }
        int cnt = 0;
        int a = -1, b = -1;
        for (int i = 0; i < n; ++i) {
            if (s[i] != goal[i]) {
                cnt++;
                if (cnt == 1) a = i;
                else if (cnt == 2) b = i;
                else return false;
            }
        }
        if (cnt == 2) {
            swap(s[a], s[b]);
            return s == goal;
        }
        return false;
    }
};