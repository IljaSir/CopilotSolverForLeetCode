class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        
        vector<string> res;
        vector<int> cnt(26, INT_MAX);
        for (auto& w : words) {
            vector<int> cnt2(26);
            for (auto c : w) ++cnt2[c - 'a'];
            for (int i = 0; i < 26; ++i) cnt[i] = min(cnt[i], cnt2[i]);
        }
        for (int i = 0; i < 26; ++i) {
            string t(cnt[i], i + 'a');
            res.push_back(t);
        }
        return res;
    }
};