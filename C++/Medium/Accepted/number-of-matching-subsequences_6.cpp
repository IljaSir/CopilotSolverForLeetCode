class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        
        int ans = 0;
        vector<int> pos[26];
        for (int i = 0; i < s.size(); i++) {
            pos[s[i]-'a'].push_back(i);
        }
        for (string& word: words) {
            int prev = -1;
            bool ok = true;
            for (char c: word) {
                auto it = upper_bound(pos[c-'a'].begin(), pos[c-'a'].end(), prev);
                if (it == pos[c-'a'].end()) {
                    ok = false;
                    break;
                }
                prev = *it;
            }
            ans += ok;
        }
        return ans;
    }
};