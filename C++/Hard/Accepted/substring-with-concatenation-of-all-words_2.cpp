class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        
        vector<int> res;
        if (words.size() == 0) return res;
        int len = words[0].size();
        if (s.size() < len * words.size()) return res;
        
        unordered_map<string, int> cnt;
        for (auto& word : words) cnt[word]++;
        
        for (int i = 0; i < len; i++) {
            int l = i, r = i;
            unordered_map<string, int> tmp;
            int match = 0;
            while (r + len <= s.size()) {
                string w = s.substr(r, len);
                r += len;
                if (cnt.find(w) != cnt.end()) {
                    tmp[w]++;
                    if (tmp[w] <= cnt[w]) match++;
                    while (tmp[w] > cnt[w]) {
                        string leftmost = s.substr(l, len);
                        l += len;
                        tmp[leftmost]--;
                        if (tmp[leftmost] < cnt[leftmost]) match--;
                    }
                    if (match == words.size()) res.push_back(l);
                } else {
                    l = r;
                    tmp.clear();
                    match = 0;
                }
            }
        }
        return res;
    }
};