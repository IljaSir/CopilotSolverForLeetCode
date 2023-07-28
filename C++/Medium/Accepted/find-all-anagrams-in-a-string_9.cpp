class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> res;
        int len = p.size();
        unordered_map<char, int> m;
        for (char c : p) m[c]++;
        int cnt = m.size();
        int l = 0, r = 0;
        while (r < s.size()) {
            if (m.count(s[r])) {
                if (--m[s[r]] == 0) cnt--;
            }
            r++;
            while (cnt == 0) {
                if (r - l == len) res.push_back(l);
                if (m.count(s[l])) {
                    if (++m[s[l]] > 0) cnt++;
                }
                l++;
            }
        }
        return res;
    }
};