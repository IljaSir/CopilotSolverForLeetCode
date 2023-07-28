class Solution {
public:
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        
        int cnt = 0;
        for (string& target : targetWords) {
            for (string& start : startWords) {
                if (isConvertable(start, target)) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
    bool isConvertable(string& s, string& t) {
        if (s.size() > t.size()) return false;
        int m = s.size(), n = t.size();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else {
                j++;ount == 0) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
};