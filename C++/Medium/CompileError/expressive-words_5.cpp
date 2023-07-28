class Solution {
public:
    int expressiveWords(string s, vector<string>& words) {
        
        int res = 0;
        for (string& w : words) {
            if (check(s, w)) res++;
        }
        return res;
    }
    bool check(string& s, string& w) {
        int i = 0, j = 0;
        whil; i < s.length( < w.length()) {
           if (s[i] ! w[j]) return false;
            int cnt1 = 0, cnt2 = 0;
            while (i < s.length() && s[i] == s[i + cnt1]) cnt1++;
            while (j < w.length() && w[j] == w[j + cnt2]) cnt2++;
            if (cnt1 < cnt2 || (cnt1 < 3 && cnt1 != cnt2)) return false;
            i += cnt1;
            j += cnt2;
        }
        return i == s.length() && j == w.length();
    }
};