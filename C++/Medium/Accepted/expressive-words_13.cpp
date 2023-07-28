class Solution {
public:
    int expressiveWords(string s, vector<string>& words) {
        
        int count = 0;
        for (auto w : words) {
            if (isStretchy(s, w)) count++;
        }
        return count;
    }
    
    bool isStretchy(string s, string w) {
        int i = 0, j = 0;
        while (i < s.size() && j < w.size()) {
            if (s[i] != w[j]) return false;
            int len1 = 0, len2 = 0;
            while (i < s.size() && s[i] == s[i + 1]) {
                i++;
                len1++;
            }
            while (j < w.size() && w[j] == w[j + 1]) {
                j++;
                len2++;
            }
            if (len1 < len2 || (len1 > len2 && len1 < 2)) return false;
            i++;
            j++;
        }
        return i == s.size() && j == w.size();
    }
};