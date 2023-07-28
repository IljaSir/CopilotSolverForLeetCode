class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        
        int n = nums.size();
        long long ans = 0;
        vector<int> index(n);
        iota(index.begin(), index.end(), 0);
        sort(index.begin(), index.end(), [&](int x, int y) {
            return nums[x] - x < nums[y] - y;
        });
        vector<int> sum(n + 1);
        for (int i = 0; i < n; ++i) {
            int x = index[i];
            ans += i - sum[nums[x] - x + n];
            for (int j = nums[x] - x + n; j <= n; j += j & -j) {
                ++sum[j];
            }
        }
        return ans;
    }
};