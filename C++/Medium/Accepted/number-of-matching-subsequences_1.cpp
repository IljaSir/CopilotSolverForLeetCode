class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        
        vector<vector<int>> pos(26);
        for (int i = 0; i < s.size(); ++i) {
            pos[s[i] - 'a'].push_back(i);
        }
        int ans = 0;
        for (auto& word : words) {
            int prev = -1;
            int j = 0;
            for (; j < word.size(); ++j) {
                auto& p = pos[word[j] - 'a'];
                auto it = upper_bound(p.begin(), p.end(), prev);
                if (it == p.end()) break;
                prev = *it;
            }
            if (j == word.size()) ++ans;
        }
        return ans;
    }
};