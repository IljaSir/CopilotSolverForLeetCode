class Solution {
public:
    int minMoves(vector<int>& nums, int limit) {
        
        int n = nums.size();
        vector<int> diff(limit * 2 + 2);
        for (int i = 0; i < n / 2; ++i) {
            int a = nums[i], b = nums[n - 1 - i];
            int s = a + b;
            diff[2] += 2;
            diff[s] -= 1;
            diff[s + 1] += 1;
            diff[a + b + 1] -= 1;
            diff[a + b + limit + 1] += 1;
        }
        int ans = n, cur = n;
        for (int i = 2; i <= limit * 2; ++i) {
            cur += diff[i];
            ans = min(ans, cur);
        }
        return ans;
    }
};