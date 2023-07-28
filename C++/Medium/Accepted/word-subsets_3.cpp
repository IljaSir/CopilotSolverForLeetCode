class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<int> freq(26, 0);
        for (auto& w : words2) {
            vector<int> f(26, 0);
            for (auto& c : w) {
                f[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                freq[i] = max(freq[i], f[i]);
            }
        }
        vector<string> res;
        for (auto& w : words1) {
            vector<int> f(26, 0);
            for (auto& c : w) {
                f[c - 'a']++;
            }
            bool ok = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] > f[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                res.push_back(w);
            }
        }
        return res;
    }
};