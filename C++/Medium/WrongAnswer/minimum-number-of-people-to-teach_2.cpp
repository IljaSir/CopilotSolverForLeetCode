class Solution {
public:
    int minimumTeachings(int n, vector<vector<int>>& languages, vector<vector<int>>& friendships) {
        
        int m = languages.size();
        vector<vector<int>> can_talk(m, vector<int>(m, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int l1 : languages[i]) {
                    for (int l2 : languages[j]) {
                        if (l1 == l2) {
                            can_talk[i][j] = 1;
                        }
                    }
                }
            }
        }
        vector<int> teach(m, 0);
        for (auto& f : friendships) {
            if (can_talk[f[0] - 1][f[1] - 1] == 0) {
                teach[f[0] - 1] = 1;
                teach[f[1] - 1] = 1;
            }
        }
        vector<int> cnt(n + 1, 0);
        for (auto& t : teach) {
            if (t == 1) {
                for (auto& l : languages[t]) {
                    cnt[l]++;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = max(res, cnt[i]);
        }
        return res;
    }
};