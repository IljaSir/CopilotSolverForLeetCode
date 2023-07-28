class Solution {
public:
    string minWindow(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        int l = 0, r = 0;
        int cnt = 0;
        int minn = 1e9;
        string ans;
        unordered_map<char, int> mp;
        for (char c : t) mp[c]++;
        while (r < n) {
            if (mp[s[r]] > 0) cnt++;
            mp[s[r]]--;
            r++;
            while (cnt == m) {
                if (r - l < minn) {
                    minn = r - l;
                    ans = s.substr(l, r - l);
                }
                if (mp[s[l]] == 0) cnt--;
                mp[s[l]]++;
                l++;
            }
        }
        return ans;
    }
};