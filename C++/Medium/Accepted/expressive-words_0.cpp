class Solution {
public:
    int expressiveWords(string s, vector<string>& words) {
        
        int res = 0;
        for (string& word : words) {
            int i = 0, j = 0;
            while (i < s.size() && j < word.size()) {
                if (s[i] != word[j]) break;
                int cnt1 = 0, cnt2 = 0;
                while (i < s.size() && s[i] == s[i + cnt1]) cnt1++;
                while (j < word.size() && word[j] == word[j + cnt2]) cnt2++;
                if (cnt1 < cnt2 || (cnt1 < 3 && cnt1 != cnt2)) break;
                i += cnt1;
                j += cnt2;
            }
            if (i == s.size() && j == word.size()) res++;
        }
        return res;
    }
};