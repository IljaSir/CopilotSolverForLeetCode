class Solution {
public:
    int minimumTimeRequired(vector<int>& jobs, int k) {
        
        sort(jobs.begin(), jobs.end());
        reverse(jobs.begin(), jobs.end());
        int l = jobs[0], r = accumulate(jobs.begin(), jobs.end(), 0);
        while (l < r) {
            int mid = l + r >> 1;
            if (check(jobs, k, mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    bool check(vector<int>& jobs, int k, int limit) {
        vector<int> sum(k);
        return dfs(jobs, sum, 0, limit);
    }
    bool dfs(vector<int>& jobs, vector<int>& sum, int u, int limit) {
        if (u == jobs.size()) return true;
        int x = jobs[u];
        for (int i = 0; i < sum.size(); i++) {
            if (sum[i] + x <= limit) {
                sum[i] += x;
                if (dfs(jobs, sum, u + 1, limit)) return true;
                sum[i] -= x;
            }
            if (!sum[i] || sum[i] + x == limit) break;
        }
        return false;
    }
};