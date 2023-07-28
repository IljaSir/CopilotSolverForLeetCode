class Solution {
public:
    int countPrefixes(vector<string>& words, string s) {
        
        int res = 0;
        for (auto& w : words) {
            if (w.size() <= s.size()) {
                bool ok = true;
                for (int i = 0; i < w.size(); i++) {
                    if (w[i] != s[i]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) res++;
            }
        }
        return res;
    }
};