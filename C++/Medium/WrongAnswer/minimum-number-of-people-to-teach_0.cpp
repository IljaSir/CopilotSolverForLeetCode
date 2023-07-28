class Solution {
public:
    int minimumTeachings(int n, vector<vector<int>>& languages, vector<vector<int>>& friendships) {
        
        int m = languages.size();
        vector<vector<int>> common(m, vector<int>(m, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                for (int l1 : languages[i]) {
                    for (int l2 : languages[j]) {
                        if (l1 == l2) {
                            common[i][j] = 1;
                            break;
                        }
                    }
                }
            }
        }
        vector<int> cnt(n+1, 0);
        for (auto& f : friendships) {
            int a = f[0]-1, b = f[1]-1;
            if (common[a][b] == 0) {
                for (int l : languages[a]) {
                    cnt[l]++;
                }
                for (int l : languages[b]) {
                    cnt[l]++;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = max(ans, cnt[i]);
        }
        return ans;
    }
};