class Solution {
public:
    int largestComponentSize(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> p(n);
        iota(p.begin(), p.end(), 0);
        for (int i = 0; i < n; ++i) {
            int x = nums[i];
            for (int j = 2; j * j <= x; ++j) {
                if (x % j == 0) {
                    int a = find(p, i), b = find(p, lower_bound(nums.begin(), nums.end(), j) - nums.begin());
                    if (a != b) p[a] = b;
                    while (x % j == 0) x /= j;
                }
            }
            if (x > 1) {
                int a = find(p, i), b = find(p, lower_bound(nums.begin(), nums.end(), x) - nums.begin());
                if (a != b) p[a] = b;
            }
        }
        unordered_map<int, int> cnt;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = max(ans, ++cnt[find(p, i)]);
        }
        return ans;
    }
};