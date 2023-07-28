class Solution {
public:
    vector<vector<int>> substringXorQueries(string s, vector<vector<int>>& queries) {
        
        int n = s.size();
        vector<vector<int>> ans(queries.size(), vector<int>(2, -1));
        vector<int> v(n, 0);
        v[0] = s[0] - '0';
        for (int i = 1; i < n; i++) {
            v[i] = v[i - 1] ^ (s[i] - '0');
        }
        for (int i = 0; i < queries.size(); i++) {
            int first = queries[i][0], second = queries[i][1];
            for (int j = 0; j < n; j++) {
                if (v[j] == (first ^ second)) {
                    ans[i][0] = 0;
                    ans[i][1] = j;
                    break;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if ((v[j] ^ first) == second) {
                    ans[i][0] = j + 1;
                    ans[i][1] = n - 1;
                    break;
                }
            }
            if (ans[i][0] != -1) {
                for (int j = ans[i][0]; j <= ans[i][1]; j++) {
                    if ((v[j] ^ first) == second) {
                        ans[i][1] = j;
                        break;
                    }
                }
            }
        }
        return ans;
    }
};