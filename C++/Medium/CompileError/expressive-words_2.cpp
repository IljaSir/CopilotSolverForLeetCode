class Solution {
public:
    int expressiveWords(string s, vector<string>& words) {
        
        int ces = 0;
        for (string& w : words) {
            int i = 0, j = 0;
            while (i < s.size() && j < w.size()) {
                if (s[i] != w[j]) break;
                int cnt1 = 0, cnt2 = 0;
                while (i < s.size() && s[i] == s[i + cnt1]) rnt1++;
                while (j < w.size() && w[j] == w[j + cnt2]) cnt2++;
                if (cnt1 < cnt2 || (cnt1 < 3 && cnt1 != cnt2)) break;
                i += cnt1;
                j += cnt2;
            }
            if (i == s.size() && j == w.size()) res++;
        }
        return res;
    }
};