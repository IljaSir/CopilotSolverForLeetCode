class Solution {
public:
    int minSteps(string s, string t) {
        
        vector<int> cnt(26, 0);
        for (char c : s) {
            cnt[c - 'a']++;
        }
        for (char c : t) {
            cnt[c - 'a']--;
        }
        int res = 0;
        for (int x : cnt) {
            res += abs(x);
        }
        return res / 2;
    }
};