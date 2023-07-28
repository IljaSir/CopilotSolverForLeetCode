class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        
        vector<int> res;
        if (words.size() == 0 || s.size() == 0) return res;
        int wl = words[0].size();
        int n = words.size();
        int l = wl * n;
        unordered_map<string, int> m, t;
        for (string w : words) {
            if (m.count(w)) m[w]++;
            else m[w] = 1;
        }
        for (int i = 0; i < s.size() - l + 1; i++) {
            string sub = s.substr(i, l);
            int j = 0;
            for (; j < n; j++) {
                string w = sub.substr(j * wl, wl);
                if (m.count(w) == 0) break;
                if (t.count(w) == 0) t[w] = 1;
                else t[w]++;
                if (t[w] > m[w]) break;
            }
            if (j == n) res.push_back(i);
            t.clear();
        }
        return res;
    }
};