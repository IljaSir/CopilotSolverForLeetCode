class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        
        int n = flowers.size();
        int m = people.size();
        vector<int> ans(m, 0);
        vector<vector<int>> f(n, vector<int>(2, 0));
        for (int i = 0; i < n; ++i) {
            f[i][0] = flowers[i][0];
            f[i][1] = flowers[i][1];
        }
        sort(f.begin(), f.end(), [](vector<int>& a, vector<int>& b) {
            if (a[0] == b[0]) return a[1] < b[1];
            return a[0] < b[0];
        });
        int idx = 0;
        int maxRight = 0;
        for (int i = 0; i < m; ++i) {
            while (idx < n && f[idx][0] <= people[i]) {
                maxRight = max(maxRight, f[idx][1]);
                ++idx;
            }
            ans[i] = idx;
            if (people[i] <= maxRight) --ans[i];
        }
        return ans;
    }
};