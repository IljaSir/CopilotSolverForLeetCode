class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        
        int n = nums.size();
        int m = queries.size();
        vector<int> ans(m);
        vector<int> p(n);
        vector<int> q(n);
        p[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            p[i] = p[i - 1] + nums[i];
        }
        q[0] = 1;
        for (int i = 1; i < n; ++i) {
            q[i] = q[i - 1] + (p[i] - p[i - 1] > 1);
        }
        for (int i = 0; i < m; ++i) {
            int l = 0;
            int r = n - 1;
            int last = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (p[mid] <= queries[i]) {
                    last = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (last == -1) {
                ans[i] = 0;
            } else {
                ans[i] = q[last];
            }
        }
        return ans;
    }
};