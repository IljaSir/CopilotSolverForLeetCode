class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        
        if (words.empty()) return {};
        const int n = s.size();
        const int m = words.size();
        const int k = words[0].size();
        const int l = m * k;
        vector<int> res;
        unordered_map<string, int> freq;
        for (const auto& w : words) {
            ++freq[w];
        }
        for (int i = 0; i < n - l + 1; ++i) {
            unordered_map<string, int> seen;
            int j = 0;
            for (; j < m; ++j) {
                string t = s.substr(i + j * k, k);
                if (freq.find(t) == freq.end() || seen[t] == freq[t]) {
                    break;
                }
                ++seen[t];
            }
            if (j == m) {
                res.push_back(i);
            }
        }
        return res;
    }
};