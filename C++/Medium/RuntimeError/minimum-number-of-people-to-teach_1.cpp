class Solution {
public:
    int minimumTeachings(int n, vector<vector<int>>& languages, vector<vector<int>>& friendships) {
        
        int m = languages.size();
        vector<int> lang(m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < languages[i].size(); j++) {
                lang[i] |= 1 << (languages[i][j] - 1);
            }
        }
        vector<int> cnt(n + 1);
        for (auto& f : friendships) {
            if ((lang[f[0] - 1] & lang[f[1] - 1]) == 0) {
                cnt[f[0]]++;
                cnt[f[1]]++;
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            res = max(res, cnt[i]);
        }
        return res;
    }
};