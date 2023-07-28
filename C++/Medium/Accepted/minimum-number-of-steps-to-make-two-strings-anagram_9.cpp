class Solution {
public:
    int minSteps(string s, string t) {
        
        int n = s.length();
        int m = t.length();
        if (n != m) return 0;
        unordered_map<char, int> map;
        for (auto c: s) map[c]++;
        for (auto c: t) map[c]--;
        int ans = 0;
        for (auto it: map) {
            ans += max(0, it.second);
        }
        return ans;
    }
};