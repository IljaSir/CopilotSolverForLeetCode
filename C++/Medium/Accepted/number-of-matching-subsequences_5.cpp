class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        
        int n = s.size();
        int m = words.size();
        int ans = 0;
        vector<vector<int>> pos(26);
        for (int i = 0; i < n; i++) {
            pos[s[i] - 'a'].push_back(i);
        }
        for (int i = 0; i < m; i++) {
            int len = words[i].size();
            int idx = -1;
            bool flag = true;
            for (int j = 0; j < len; j++) {
                char c = words[i][j];
                auto it = upper_bound(pos[c - 'a'].begin(), pos[c - 'a'].end(), idx);
                if (it == pos[c - 'a'].end()) {
                    flag = false;
                    break;
                }
                idx = *it;
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
};