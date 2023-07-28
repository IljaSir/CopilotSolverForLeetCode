class Solution {
public:
    bool buddyStrings(string s, string goal) {
        
        if (s.size() != goal.size()) return false;
        if (s == goal) {
            unordered_set<char> set;
            for (char c: s) {
                if (set.count(c)) return true;
                set.insert(c);
            }
            return false;
        }
        int n = s.size();
        int i = 0;
        while (i < n && s[i] == goal[i]) ++i;
        int j = n - 1;
        while (j >= 0 && s[j] == goal[j]) --j;
        return i < j && s[i] == goal[j] && s[j] == goal[i];
    }
};