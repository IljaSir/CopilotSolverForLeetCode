class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        
        int res = 0;
        for (string w : words) {
            int i = 0;
            for (char c : s) {
                if (i < w.size() && c == w[i]) {
                    i++;
                }
            }
            if (i == w.size()) {
                res++;
            }
        }
        return res;
    }
};