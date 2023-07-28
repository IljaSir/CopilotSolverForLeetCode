class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<int> cnt(26, 0);
        for (string &w : words2) {
            vector<int> cnt2(26, 0);
            for (char c : w) {
                cnt2[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                cnt[i] = max(cnt[i], cnt2[i]);
            }
        }
        vector<string> res;
        for (string &w : words1) {
            vector<int> cnt2(26, 0);
            for (char c : w) {
                cnt2[c - 'a']++;
            }
            bool ok = true;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > cnt2[i]) {
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