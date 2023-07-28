class Solution {
public:
    vector<vector<int>> substringXorQueries(string s, vector<vector<int>>& queries) {
        
        vector<vector<int>> ans;
        int n = s.size();
        vector<int> a(n, 0);
        for (int i = 0; i < n; i++) {
            a[i] = s[i] - '0';
        }
        for (auto& q : queries) {
            int first = q[0], second = q[1];
            int left = -1, right = -1;
            for (int i = 0; i < n; i++) {
                int cur = first ^ a[i];
                if (cur == second) {
                    left = i;
                    for (int j = i; j < n; j++) {
                        cur ^= a[j];
                        if (cur == second) {
                            right = j;
                        }
                    }
                    break;
                }
            }
            ans.push_back({left, right});
        }
        return ans;
    }
};