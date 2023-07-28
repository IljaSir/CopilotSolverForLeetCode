class Solution {
public:
    int minSteps(string s, string t) {
        
        unordered_map<char, int> mp;
        for (auto c : s) {
            mp[c]++;
        }
        int cnt = 0;
        for (auto c : t) {
            if (mp.count(c) && mp[c] > 0) {
                mp[c]--;
            } else {
                cnt++;
            }
        }
        return cnt;
    }
};