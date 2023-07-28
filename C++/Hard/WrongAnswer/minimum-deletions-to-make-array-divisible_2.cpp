class Solution {
public:
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        
        int n = nums.size(), m = numsDivide.size();
        long long gcd = numsDivide[0];
        for (int i = 1; i < m; ++i) {
            gcd = __gcd(gcd, (long long)numsDivide[i]);
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] % gcd != 0) {
                return -1;
            }
        }
        sort(nums.begin(), nums.end());
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] % gcd != 0) {
                cnt++;
            }
        }
        return cnt;
    }
};