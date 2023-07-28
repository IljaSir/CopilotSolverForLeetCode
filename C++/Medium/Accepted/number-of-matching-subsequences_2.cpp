class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        
        int ans = 0;
        vector<vector<int>> pos(26);
        for (int i = 0; i < s.size(); i++) {
            pos[s[i] - 'a'].push_back(i);
        }
        for (auto& word: words) {
            int i = 0;
            for (auto c: word) {
                auto& p = pos[c - 'a'];
                auto it = lower_bound(p.begin(), p.end(), i);
                if (it == p.end()) {
                    i = -1;
                    break;
                }
                i = *it + 1;
            }
            ans += i >= 0;
        }
        return ans;
    }
};