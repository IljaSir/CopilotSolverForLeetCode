class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 3) return 0;
        vector<unordered_map<long, int>> f(n);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long)nums[i] - nums[j];
                int cnt = 0;
                if (f[j].count(d)) {
                    cnt = f[j][d];
                }
                f[i][d] += cnt + 1;
                ans += cnt;
            }
        }
        return ans;
    }
};