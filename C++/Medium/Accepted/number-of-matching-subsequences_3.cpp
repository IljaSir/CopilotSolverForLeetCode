class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        
        int ans = 0;
        vector<vector<int>> pos(26);
        for (int i = 0; i < s.size(); i++) {
            pos[s[i] - 'a'].push_back(i);
        }
        for (auto& word: words) {
            int cur = -1;
            bool ok = true;
            for (auto& c: word) {
                auto& vec = pos[c - 'a'];
                auto it = lower_bound(vec.begin(), vec.end(), cur + 1);
                if (it == vec.end()) {
                    ok = false;
                    break;
                }
                cur = *it;
            }
            if (ok) ans++;
        }
        return ans;
    }
};