class Solution {
public:
    int minimumTimeRequired(vector<int>& jobs, int k) {
        
        int n = jobs.size();
        vector<int> workloads(k, 0);
        int ans = INT_MAX;
        function<void(int)> backtrack = [&](int i) {
            if (i == n) {
                int curMax = *max_element(workloads.begin(), workloads.end());
                ans = min(ans, curMax);
                return;
            }
            unordered_set<int> seen;
            for (int j = 0; j < k; ++j) {
                if (seen.count(workloads[j])) {
                    continue;
                }
                if (workloads[j] + jobs[i] >= ans) {
                    continue;
                }
                seen.insert(workloads[j]);
                workloads[j] += jobs[i];
                backtrack(i + 1);
                workloads[j] -= jobs[i];
            }
        };
        backtrack(0);
        return ans;
    }
};