class Solution {
public:
    bool buddyStrings(string s, string goal) {
        
        int n = s.size();
        int m = goal.size();
        if (n != m) {
            return false;
        }
        if (s == goal) {
            unordered_map<char, int> cnt;
            for (char ch : s) {
                ++cnt[ch];
            }
            for (auto& p : cnt) {
                if (p.second >= 2) {
                    return true;
                }
            }
            return false;
        }
        vector<int> diff;
        for (int i = 0; i < n; ++i) {
            if (s[i] != goal[i]) {
                diff.push_back(i);
            }
        }
        return diff.size() == 2 && s[diff[0]] == goal[diff[1]] && s[diff[1]] == goal[diff[0]];
    }
};