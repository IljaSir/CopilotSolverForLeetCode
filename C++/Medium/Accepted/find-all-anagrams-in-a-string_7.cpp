class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        vector<int> res;
        vector<int> cnt1(128, 0);
        vector<int> cnt2(128, 0);
        int n = s.size();
        int m = p.size();
        if (n < m) return res;
        for (int i = 0; i < m; i++) {
            cnt1[s[i]]++;
            cnt2[p[i]]++;
        }
        if (cnt1 == cnt2) {
            res.push_back(0);
        }
        for (int i = m; i < n; i++) {
            cnt1[s[i]]++;
            cnt1[s[i - m]]--;
            if (cnt1 == cnt2) {
                res.push_back(i - m + 1);
            }
        }
        return res;
    }
};