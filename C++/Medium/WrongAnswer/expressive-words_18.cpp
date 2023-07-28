class Solution {
public:
    int expressiveWords(string s, vector<string>& words) {
        
        int res = 0;
        for (auto w : words) {
            if (check(s, w)) res++;
        }
        return res;
    }
    
    bool check(string& s, string& w) {
        int i = 0, j = 0, m = s.size(), n = w.size();
        while (i < m && j < n) {
            if (s[i] != w[j]) return false;
            int cnt1 = 0, cnt2 = 0;
            while (i < m && s[i] == s[i + 1]) i++, cnt1++;
            while (j < n && w[j] == w[j + 1]) j++, cnt2++;
            if (cnt1 < cnt2 || (cnt1 > 1 && cnt1 < cnt2)) return false;
            i++, j++;
        }
        return i == m && j == n;
    }
};